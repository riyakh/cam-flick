package divyanshsaxena.com.camflick.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import divyanshsaxena.com.camflick.R;

public class SellShopFragment extends Fragment {
    private static final String TAG = "SellShopFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_sell_shop, container, false);
        return view;

    }
}
