EAP 7 project template
====================================================================
Use full or full ha profile

Deploy activemq ra file

``
...
            <mdb>
                <resource-adapter-ref resource-adapter-name="${ejb.resource-adapter-name:activemq-rar.rar}"/>
                <bean-instance-pool-ref pool-name="mdb-strict-max-pool"/>
            </mdb>

...

        <subsystem xmlns="urn:jboss:domain:resource-adapters:4.0">
            <resource-adapters>
                <resource-adapter id="activemq-rar.rar">
                    <archive>
                        activemq-rar.rar
                    </archive>
                    <transaction-support>XATransaction</transaction-support>
                    <config-property name="ServerUrl">
                        tcp://127.0.0.1:61616?jms.rmIdFromConnectionId=true
                    </config-property>
                    <config-property name="UserName">
                        admin
                    </config-property>
                    <config-property name="Password">
                        admin
                    </config-property>
                    <connection-definitions>
                        <connection-definition class-name="org.apache.activemq.ra.ActiveMQManagedConnectionFactory" jndi-name="java:/amqConnectionFactory" enabled="true" pool-name="ConnectionFactory">
                            <xa-pool>
                                <min-pool-size>1</min-pool-size>
                                <max-pool-size>20</max-pool-size>
                                <prefill>false</prefill>
                                <is-same-rm-override>false</is-same-rm-override>
                            </xa-pool>
                            <recovery>
                                <recover-credential>
                                    <user-name>admin</user-name>
                                    <password>admin</password>
                                </recover-credential>
                            </recovery>
                        </connection-definition>
                    </connection-definitions>
                    <admin-objects>
                        <admin-object class-name="org.apache.activemq.command.ActiveMQQueue" jndi-name="java:/queue/testQueue" use-java-context="true" pool-name="testQueuePool">
                            <config-property name="PhysicalName">
                                testQueue
                            </config-property>
                        </admin-object>
                    </admin-objects>
                </resource-adapter>
            </resource-adapters>
        </subsystem>

``
