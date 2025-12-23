package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {
	private static final String BASE_PATH =
            System.getProperty("user.dir") + "/UtilityFile/";

    private static final String DOCTOR_FILE =
            BASE_PATH+"doctor.properties";

    private static final String WARD_FILE =
           BASE_PATH+"ward.properties";
    private static final String NURSE_FILE =
            BASE_PATH+"nurse.properties";
    
    private static final String GATEWAY_FILE =
            BASE_PATH+ "gateway.properties";

    private static final String BED_FILE =
    		BASE_PATH + "bed.properties";

    

    private static final String PATIENT_FILE =
            BASE_PATH + "patient.properties";

    private static final String SHIFT_FILE =
            BASE_PATH + "shift.properties";
    
    private static final String DEVICE_FILE =
            BASE_PATH + "device.properties";
    
    public static void saveDoctorCode(String doctorCode) {
        saveProperty(DOCTOR_FILE, "doctorcode", doctorCode, "Doctor Test Data");
    }

    public static String getDoctorCode() {
        return getProperty(DOCTOR_FILE, "doctorcode");
    }

    public static void saveWardCode(String wardCode) {
        saveProperty(WARD_FILE, "wardcode", wardCode, "Ward Test Data");
    }

    public static String getWardCode() {
        return getProperty(WARD_FILE, "wardcode");
    }
    public static void saveNurseCode(String nurseCode) {
        saveProperty(NURSE_FILE, "nursecode", nurseCode, "Nurse Test Data");
    }

    public static String getNurseCode() {
        return getProperty(NURSE_FILE, "nursecode");
    }
    
    public static void saveGatewayCode(String gatewayCode) {
        saveProperty(GATEWAY_FILE, "gatewaycode", gatewayCode, "gateway Test Data");
    }

    public static String getGatewayCode() {
        return getProperty(GATEWAY_FILE, "gatewaycode");
    }
    public static void saveBedCode(String bedCode) {
        saveProperty(BED_FILE, "bedcode", bedCode, "bed Test Data");
    }

    public static String getBedCode() {
        return getProperty(BED_FILE, "bedcode");
    }
    public static void savePatientCode(String patientCode) {
        saveProperty(PATIENT_FILE, "patientcode", patientCode, "patient Test Data");
    }

    public static String getPatientCode() {
        return getProperty(PATIENT_FILE, "patientcode");
    }
    
    public static void saveShiftCode(String ShiftCode) {
        saveProperty(SHIFT_FILE, "shiftcode", ShiftCode, "shift Test Data");
    }

    public static String getShiftCode() {
        return getProperty(SHIFT_FILE, "shiftcode");
    }
    
    public static void saveDeviceCode(String DeviceCode) {
        saveProperty(DEVICE_FILE, "devicecode", DeviceCode, "device Test Data");
    }
    public static String getDeviceCode() {
        return getProperty(DEVICE_FILE, "devicecode");
    }
    
    
    
    
    
    private static void saveProperty(String filepath, String key, String value, String comment) {
        Properties props = new Properties();
        File file = new File(filepath);

        try {
            if (file.exists()) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    props.load(fis);
                }
            }

            props.setProperty(key, value);

            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            try (FileOutputStream fos = new FileOutputStream(file)) {
                props.store(fos, comment);
            }

            System.out.println(key + " saved successfully: " + value);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getProperty(String filepath, String key) {
        Properties props = new Properties();
        File file = new File(filepath);

        if (!file.exists()) {
            System.out.println("File not found: " + filepath);
            return null; 
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            props.load(fis);
            return props.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
