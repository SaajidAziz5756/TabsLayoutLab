//Saajid Aziz   n01555756
package john.smith.tabslayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragmentAziz#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragmentAziz extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsFragmentAziz() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragmentAziz newInstance(String param1, String param2) {
        SettingsFragmentAziz fragment = new SettingsFragmentAziz();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        TextView txt = view.findViewById(R.id.SaajidCv);

        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                String setColor = result.getString("send");

                String red = getString(R.string.red);
                String green = getString(R.string.green);
                String yellow = getString(R.string.yellow);
                String other = getString(R.string.other);
                String text = getString(R.string.the_chosen_color_is) + setColor;

                int col;

                if (setColor == null)
                    text = getString(R.string.the_chosen_color_is_no_data);
                if (setColor.equals(red))
                    col = R.color.red;
                else if (setColor.equals(green))
                    col = R.color.green;
                else if (setColor.equals(yellow))
                    col = R.color.yellow;
                else
                    col = R.color.black;

                txt.setTextColor(ContextCompat.getColor(requireContext(),col));
                txt.setText(text);


            }
        });

        return view;

    }

}