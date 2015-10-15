import edu.buffalo.cse.maybeclient.MaybeClient;
import edu.buffalo.cse.maybeclient.rest.Device;
import com.google.gson.Gson;
import edu.buffalo.cse.maybeclient.rest.EmptyResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * This Java source file was auto generated by running 'gradle init --type java-library'
 * by 'xcv58' at '10/15/15 9:47 AM' with Gradle 2.7
 *
 * @author xcv58, @date 10/15/15 9:47 AM
 */
public class MaybeClientTest {
    private final String VALID_BASE_URL = "http://maybe.cse.buffalo.edu/maybe-api-v1/";
    private final String VALID_DEVICE_ID = "junit_test";

    private final Gson gson = new Gson();

    private boolean deviceExist;

    @Before public void setUpSync() {
        Device device = new MaybeClient().getDevice(VALID_BASE_URL, VALID_DEVICE_ID);
        deviceExist = device != null;
    }

    @Test public void testSync() {
        MaybeClient maybeClient = new MaybeClient();
        Device device = maybeClient.sync(VALID_BASE_URL, VALID_DEVICE_ID);
        if (device == null) {
            deviceExist = false;
        }
        gson.toJson(device, Device.class);
        assertNotNull("sync should return valid result", device);
        deviceExist = true;
        assertEquals("the device should have same device id", VALID_DEVICE_ID, device.deviceid);
        assertNotNull("the device.choices should not null", device.choices);
        assertNotEquals("the device.choices should not empty", 0, device.choices.size());
    }

    @After public void cleanUpSync() {
        Device device = new MaybeClient().getDevice(VALID_BASE_URL, VALID_DEVICE_ID);
        EmptyResponse delResponse = new MaybeClient().delDevice(VALID_BASE_URL, VALID_DEVICE_ID);
        if (deviceExist) {
            assertNotNull("device exist, so getDevice() should return not null", device);
            assertNotNull("device exist, so delDevice() should return not null", delResponse);
        } else {
            assertNull("device exist, so getDevice() should return null", device);
            assertNull("device exist, so delDevice() should return null", delResponse);
        }
    }
}
