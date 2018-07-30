package divyanshsaxena.com.camflick.fragment;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.dynamite.DynamiteModule;
import com.nostra13.universalimageloader.core.ImageLoader;

import divyanshsaxena.com.camflick.R;
import divyanshsaxena.com.camflick.Utilities.UniversalImageLoader;

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";
    private ImageView mprofileimage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);
        mprofileimage = (ImageView) view.findViewById(R.id.profile_photo);
        setProfileImage();
        ImageView imageView = (ImageView) view.findViewById(R.id.profilebackmenu);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: navigating to back menu");
                getActivity().finish();
            }
        });

        return view;
    }



    private void setProfileImage() {

        Log.d(TAG, "setProfileImage: setting up the image");
        String imgURL = "images.idgesg.net/images/article/2017/08/android_robot_logo_by_ornecolorada_cc0_via_pixabay1904852_wide-100732483-large.jpg";
        UniversalImageLoader.setImage(imgURL, mprofileimage, null, "https://");

    }

}
