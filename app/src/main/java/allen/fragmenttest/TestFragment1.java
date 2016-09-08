package allen.fragmenttest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment1 extends Fragment {
    MainActivity mainActivity;
    FragmentStack flowManager;

    public TestFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_fragment1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) flowManager = mainActivity.getFragmentStack();
        Button bt = (Button) getView().findViewById(R.id.btBAck);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowManager.push(new TesFragment2());
            }
        });
    }
}
