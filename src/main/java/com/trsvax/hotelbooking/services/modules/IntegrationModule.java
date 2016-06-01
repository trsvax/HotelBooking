package com.trsvax.hotelbooking.services.modules;


import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.ServiceBuilder;
import org.apache.tapestry5.ioc.ServiceResources;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.ImportModule;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.services.ServiceOverride;

import com.trsvax.hotelbooking.Listing;
import com.trsvax.hotelbooking.services.DAO;
import com.trsvax.hotelbooking.services.EmailService;
import com.trsvax.hotelbooking.services.HotelService;
import com.trsvax.hotelbooking.services.HotelServiceImpl;
import com.trsvax.hotelbooking.services.ListingImpl;
import com.trsvax.hotelbooking.services.SendEmailLogger;
import com.trsvax.hotelbooking.services.UserService;
import com.trsvax.hotelbooking.services.UserServiceImpl;
import com.trsvax.hotelbooking.services.documentation.hotelbooking.HotelBookingDocumentationModule;
import com.trsvax.hotelbooking.services.hibernate.HibernateDAO;
import com.trsvax.jacquard.services.JacquardModule;
import com.trsvax.tapestry.documentation.services.modules.TapestryDocumentationModule;

/**
 * This module is automatically included as part of the Tapestry IoC Registry if <em>tapestry.execution-mode</em>
 * includes <code>development</code>.
 */
@ImportModule({TapestryDocumentationModule.class,HotelBookingDocumentationModule.class,JacquardModule.class})
public class IntegrationModule {

	public static void bind(ServiceBinder binder) {
	  	binder.bind(DAO.class, new ServiceBuilder<DAO>() {

				@Override
				public DAO buildService(ServiceResources resources) {
					// TODO Auto-generated method stub
					return resources.autobuild(HibernateDAO.class);
				}
			}).withId("testDAO");
	  	binder.bind(UserService.class, new ServiceBuilder<UserService>() {

			@Override
			public UserService buildService(ServiceResources resources) {
				// TODO Auto-generated method stub
				return resources.autobuild(UserServiceImpl.class);
			}
		}).withId("testUserService");
	  	binder.bind(HotelService.class, new ServiceBuilder<HotelService>() {

			@Override
			public HotelService buildService(ServiceResources resources) {
				// TODO Auto-generated method stub
				return resources.autobuild(HotelServiceImpl.class);
			}
		}).withId("testHotelService");
	  	
	  	binder.bind(EmailService.class, new ServiceBuilder<EmailService>() {

			@Override
			public EmailService buildService(ServiceResources resources) {
				// TODO Auto-generated method stub
				return resources.autobuild(SendEmailLogger.class);
			}
		}).withId("testEmailService");
	  	
	  	binder.bind(Listing.class, new ServiceBuilder<Listing>() {

			@Override
			public Listing buildService(ServiceResources resources) {
				// TODO Auto-generated method stub
				return resources.autobuild(ListingImpl.class);
			}
		}).withId("testListngService");
	}
	
    public static void contributeApplicationDefaults(MappedConfiguration<String, Object> configuration) {


        //configuration.override(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT-DEV");
       
    }
    
    
    @Contribute(ServiceOverride.class)
    public static void setupApplicationServiceOverrides(@SuppressWarnings("rawtypes") MappedConfiguration<Class,Object> configuration,
    		@Local DAO dao, @Local UserService userService, @Local HotelService hotelService, 
    		@Local EmailService emailService, @Local Listing listing)
    {
      configuration.add(DAO.class, dao);
      configuration.add(UserService.class, userService);
      configuration.add(HotelService.class, hotelService);
      configuration.add(EmailService.class, emailService);
      configuration.add(Listing.class, listing);

    }
    
}
