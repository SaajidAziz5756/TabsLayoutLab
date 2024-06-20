//Saajid Aziz   N01555756
package john.smith.tabslayout;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragmentSaajid#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragmentSaajid extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragmentSaajid() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragmentSaajid newInstance(String param1, String param2) {
        HomeFragmentSaajid fragment = new HomeFragmentSaajid();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RadioGroup rg = view.findViewById(R.id.SaajidradioGroup);
        Button btn = view.findViewById(R.id.SaajidSubmit);
        rg.check(R.id.SaajidradioButton);

        btn.setOnClickListener(v -> {

            int selection = rg.getCheckedRadioButtonId();
            RadioButton rb = view.findViewById(selection);
            String color = rb.getText().toString();
            createToast(color);
//            Color clr = Color.valueOf(rb.getCurrentTextColor());

            Bundle send = new Bundle();
            send.putString("send", color);
            getParentFragmentManager().setFragmentResult("key", send);


        });





        return view;
    }

    private void createToast(String colour)
    {
        Toast.makeText(getActivity(), colour, Toast.LENGTH_LONG).show();

        
    }


}