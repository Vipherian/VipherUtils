package dev.vipherian.vipherutils.cloud;

import org.jetbrains.annotations.NotNull;

public final class CloudSystem {

    private static String verificationKey;
    private static Integer port = 8686;
    private static String address = "localhost";


    /** Creates a new temporary service in the cloud via an HTTP interface
     * @param templateName The name of the folder in the "templates" folder of the cloud where the service files are located
     * @return Returns whether the operation was performed successfully
     */
    public static boolean create(@NotNull String templateName){
        if(verificationKey == null){
            return false;
        }
        try {
            HttpUtils.request("http://" + address + ":" + port + "/boot" + "?template=" + templateName + "&key=" + verificationKey);

            return true;
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
        return false;
    }

    /** Delete a temporary service in the cloud via an HTTP interface
     * @param templateName The name of the folder in the "templates" folder of the cloud where the service files are located
     * @return Returns whether the operation was performed successfully
     */
    public static boolean delete(@NotNull String templateName){
        if(verificationKey == null){
            return false;
        }
        try {
            HttpUtils.request("http://" + address + ":" + port + "/shutdown" + "?template=" + templateName + "&key=" + verificationKey);

            return true;
        }catch (Exception ignore){}
        return false;
    }

    /** Re-created a temporary service in the cloud via an HTTP interface
     * @param templateName The name of the folder in the "templates" folder of the cloud where the service files are located
     * @return Returns whether the operation was performed successfully
     */
    public static boolean reCreate(@NotNull String templateName){
        if(verificationKey == null){
            return false;
        }
        try {
            HttpUtils.request("http://" + address + ":" + port + "/recreate" + "?template=" + templateName + "&key=" + verificationKey);

            return true;
        }catch (Exception ignore){}
        return false;
    }

    /** Verify yourself with the CloudSystem
     * @param key The verification key which is handed out on request
     */
    public static void setupVerification(@NotNull String key){
        verificationKey = key;
    }

    /** Resets the port for accessing the cloud
     * @param cloudPort The port
     */
    public static void setPort(@NotNull Integer cloudPort){
        port = cloudPort;
    }

    /** Resets the address for accessing the cloud
     * @param cloudAddress The address
     */
    public static void setAddress(@NotNull String cloudAddress){
        address = cloudAddress;
    }
}
