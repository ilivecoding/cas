package org.apereo.cas.monitor;

import org.apereo.cas.config.CasCoreUtilConfiguration;
import org.apereo.cas.monitor.config.LdapMonitorConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Unit test for {@link PooledLdapConnectionFactoryMonitor} class.
 *
 * @author Marvin S. Addison
 * @since 4.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LdapMonitorConfiguration.class,
    CasCoreUtilConfiguration.class,
    RefreshAutoConfiguration.class})
@TestPropertySource(locations = {"classpath:/ldapmonitor.properties"})
public class PooledConnectionFactoryMonitorTests {

    @Autowired
    @Qualifier("pooledLdapConnectionFactoryMonitor")
    private Monitor monitor;

    @Test
    public void verifyObserve() {
        assertEquals(StatusCode.OK, monitor.observe().getCode());
    }
}
