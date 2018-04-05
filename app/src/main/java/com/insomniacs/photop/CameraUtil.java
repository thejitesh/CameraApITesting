package com.insomniacs.photop;

import android.hardware.Camera;

/**
 * Created by INSODROID1 on 05-04-2018.
 */

public class CameraUtil {

    public static int cameraId = Camera.CameraInfo.CAMERA_FACING_FRONT;

    public static boolean isFrontFacing() {
        return cameraId == Camera.CameraInfo.CAMERA_FACING_FRONT;
    }

    public static void switchCamera() {

        if (cameraId == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            cameraId = Camera.CameraInfo.CAMERA_FACING_BACK;
        } else {
            cameraId = Camera.CameraInfo.CAMERA_FACING_FRONT;
        }
    }


}
