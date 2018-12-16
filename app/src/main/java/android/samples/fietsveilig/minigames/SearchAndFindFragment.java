package android.samples.fietsveilig.minigames;


import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import android.samples.fietsveilig.R;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.IOException;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchAndFindFragment extends Fragment {
    CameraPreview m_cameraPreview;


    public SearchAndFindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View UI = inflater.inflate(R.layout.fragment_search_and_find, container, false);
        Camera cam = getCameraInstance();
        if (cam != null) {
            m_cameraPreview = new CameraPreview(getContext(), getCameraInstance());
            FrameLayout preview = (FrameLayout) UI.findViewById(R.id.camera_preview);
            preview.addView(m_cameraPreview);
        }
        else {
            Toast.makeText(getActivity(), "de camera is nodig voor deze minigame maar deze is niet beschikbaar.",
                    Toast.LENGTH_LONG).show();
        }
        // Inflate the layout for this fragment
        return UI;
    }

    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
            Log.d(TAG, "No camera available");
        }
        return c; // returns null if camera is unavailable
    }


    @Override
    public void onDestroy() {
        try {
            m_cameraPreview.getmCamera().release();
        }
        catch (Exception e){

        }
        super.onDestroy();
    }

    public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
        private SurfaceHolder mHolder;
        private Camera mCamera;

        public CameraPreview(Context context, Camera camera) {
            super(context);
            mCamera = camera;
            // Install a SurfaceHolder.Callback so we get notified when the
            // underlying surface is created and destroyed.
            mHolder = getHolder();
            mHolder.addCallback(this);
        }

        public Camera getmCamera() {
            return mCamera;
        }


        public void surfaceCreated(SurfaceHolder holder) {
            // The Surface has been created, now tell the camera where to draw the preview.
            try {
                mCamera.setPreviewDisplay(holder);
                mCamera.startPreview();
            } catch (IOException e) {
                Log.d(TAG, "Error setting camera preview: " + e.getMessage());
            }
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            // empty. Take care of releasing the Camera preview in your activity.
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
            // If your preview can change or rotate, take care of those events here.
            // Make sure to stop the preview before resizing or reformatting it.

            if (mHolder.getSurface() == null) {
                // preview surface does not exist
                return;
            }

            // stop preview before making changes
            try {
                mCamera.stopPreview();
            } catch (Exception e) {
                // ignore: tried to stop a non-existent preview
            }

            // set preview size and make any resize, rotate or
            // reformatting changes here

            // start preview with new settings
            try {
                mCamera.setPreviewDisplay(mHolder);
                mCamera.startPreview();

            } catch (Exception e) {
                Log.d(TAG, "Error starting camera preview: " + e.getMessage());
            }
        }

    }
}
