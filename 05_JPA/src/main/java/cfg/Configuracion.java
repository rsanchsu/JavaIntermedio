
package cfg;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa
@Configuration //esta realmente sobraria 
@ComponentScan(basePackages = { "modelo" }) //para mezclar el javaconfig con anotaciones
//esto es igual que el arroba componene
@EnableTransactionManagement //que me habilite el gestor de transacciones 
public class Configuracion {

	@Bean //configuramos una fuente de datos ir, usuario, ....
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		/* configuracion para mysql 8.0
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jpa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("root");*/
		ds.setDriverClassName("org.h2.Driver"); //configuracion para h2, driver
		ds.setUrl("jdbc:h2:file:c:/home/pue/Dowloads/pruebaJpa"); // la url
		ds.setUsername("sa"); //para pro tendriamos un fichero de propertys o con el beans.xml
		ds.setPassword("");
		return ds;
	}

	@Bean // el entitymanager factory nos crea las factorias 
	public LocalContainerEntityManagerFactoryBean 
		entityManagerFactory(DataSource dataSource, Environment env) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = 
			new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource); //necesita la fuenta de datos que viene inyectado del bean de arriba
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter()); //la implementacion con hibernate
		entityManagerFactoryBean.setPackagesToScan("modelo.entidades");

		Properties jpaProperties = new Properties();
		/* mysql
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		*/
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");//create-drop update, la encargada
		//de como crear la base de datos create-drop borra todo cuando arranca la splicacion
		//update va creando la tablas nuevas
		jpaProperties.put("hibernate.show_sql", "true");
		jpaProperties.put("hibernate.format_sql", "false"); // para que salga formateado
		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}
	
	@Bean //gestor de transacciones , podriamos utillizar el mismo gestor para varias entidades
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
}