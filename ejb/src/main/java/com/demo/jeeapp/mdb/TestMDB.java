package com.demo.jeeapp.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.jboss.ejb3.annotation.ResourceAdapter;
import org.jboss.logging.Logger;

/**
 * Message-Driven Bean implementation class for: TestMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "testQueue"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "testQueue",messageListenerInterface = MessageListener.class)
@ResourceAdapter("activemq-rar.rar")
public class TestMDB implements MessageListener {
	
	Logger log=Logger.getLogger(getClass());
	/**
     * Default constructor. 
     */
    public TestMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        log.info("==================================== GOT MESSAGE======="+message);;
        
    }

}
