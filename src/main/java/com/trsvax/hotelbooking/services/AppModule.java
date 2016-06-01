package com.trsvax.hotelbooking.services;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.beaneditor.DataTypeConstants;
import org.apache.tapestry5.beanvalidator.BeanValidatorConfigurer;
import org.apache.tapestry5.beanvalidator.BeanValidatorSource;
import org.apache.tapestry5.beanvalidator.ClientConstraintDescriptor;
import org.apache.tapestry5.beanvalidator.ClientConstraintDescriptorSource;
import org.apache.tapestry5.internal.beanvalidator.BaseCCD;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ObjectLocator;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Autobuild;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Startup;
import org.apache.tapestry5.ioc.services.RegistryShutdownHub;
import org.apache.tapestry5.services.BeanBlockContribution;
import org.apache.tapestry5.services.BeanBlockOverrideSource;
import org.apache.tapestry5.services.BeanBlockSource;
import org.apache.tapestry5.services.EditBlockContribution;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.apache.tapestry5.services.transform.ComponentClassTransformWorker2;
import org.slf4j.Logger;

import com.trsvax.hotelbooking.entities.Address;
import com.trsvax.hotelbooking.entities.CreditCard;
import com.trsvax.hotelbooking.services.hibernate.HibernateDAO;
import com.trsvax.hotelbooking.services.hibernate.HibernateRealm;
import com.trsvax.jacquard.jsr303.DateRange;
import com.trsvax.jacquard.services.AppGlobals;
import com.trsvax.jacquard.services.worker.BeanValidateWorker;

public class AppModule {
	
    public static void bind(ServiceBinder binder) {
    	binder.bind(DAO.class,HibernateDAO.class);  	    	
    	binder.bind(UserService.class,UserServiceImpl.class);
    	binder.bind(EmailService.class,SendEmailLogger.class);  
    	binder.bind(HotelService.class,HotelServiceImpl.class);
    }
    
    public static void contributeApplicationDefaults(
            MappedConfiguration<String, Object> configuration) {
        configuration.add(SymbolConstants.ENABLE_PAGELOADING_MASK, false);

        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");
        configuration.add(SymbolConstants.JAVASCRIPT_INFRASTRUCTURE_PROVIDER, "jquery");
    }
    
    //@Contribute(DefaultDataTypeAnalyzer.class)
	public static void contributeDefaultDataTypeAnalyzer(@SuppressWarnings("rawtypes") MappedConfiguration<Class, String> configuration) {
		 configuration.add(CreditCard.class, "Object");
		 configuration.add(Address.class, "Object");
	}
    
    @Contribute(BeanBlockSource.class)
	public static void provideDefaultBeanBlocks(Configuration<BeanBlockContribution> configuration) {
    	configuration.add( new EditBlockContribution("Object", "jq/blocks/ObjectEdit", "Object"));
    }
    
    @Contribute(BeanValidatorSource.class)
    public static void provideBeanValidatorConfigurer(OrderedConfiguration<BeanValidatorConfigurer> configuration)
    {
       configuration.add("BeanValidatorConfigurer", new BeanValidatorConfigurer()
       {
          public void configure(javax.validation.Configuration<?> configuration)
          {
             configuration.ignoreXmlConfiguration();
          }
       });
    }
    
    @Contribute(BeanBlockOverrideSource.class)
	public static void contributeBeanBlockOverrideSource(Configuration<BeanBlockContribution> configuration) {
		configuration.add(new EditBlockContribution(DataTypeConstants.DATE, "PropertyEditBlocks", DataTypeConstants.TEXT));
	}
    
	@Startup
	  public static void initMyApplication(RegistryShutdownHub hub, ObjectLocator locator)
	  {
		hub.addRegistryShutdownListener(new AppGlobals(locator));
	  }
	

	
	@Contribute(ComponentClassTransformWorker2.class)
	public static void contributeTransformWorkers(OrderedConfiguration<ComponentClassTransformWorker2> workers) {
		workers.addInstance("BeanValidateWorker",BeanValidateWorker.class);		
	}
	
	@Contribute(WebSecurityManager.class)
	public static void addRealms(Configuration<Realm> configuration,
			@Autobuild HibernateRealm realm, UserService userService) {
		realm.setCredentialsMatcher(userService.getCredentialsMatcher());
		configuration.add(realm);
	}


}