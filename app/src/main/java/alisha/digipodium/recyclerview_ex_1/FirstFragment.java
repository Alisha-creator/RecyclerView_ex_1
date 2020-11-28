package alisha.digipodium.recyclerview_ex_1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    List<String> countries = new ArrayList<String>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        /*countries.add("India");
        countries.add("South korea");
        countries.add("Hawaii");
        countries.add("Australia");
        countries.add("Morocco");
        countries.add("Mauritius");
        countries.add("New Zealand");
        countries.add("Norway");
        countries.add("Philippines");
        countries.add("Russia");
        countries.add("Egypt");
        countries.add("Sweden");
        countries.add("Switzerland");
        countries.add("Singapore");
        countries.add("Japan");
        countries.add("Jordan");
        countries.add("Italy");
        countries.add("Vietnam");
        countries.add("Hungary");
        countries.add("United Arab Emirates");
        countries.add("Finland");
        countries.add("France");*/
        countries.add("Parrot");
        countries.add("Owl");
        countries.add("Columbidae");
        countries.add("Ostrich");
        countries.add("Goose");
        countries.add("Peacock");
        countries.add("Crow");
        countries.add("Vulture");
        countries.add("Eagle");
        countries.add("kingfisher");
        countries.add("Hyacinth Macaw");
        countries.add("Wood Duck");
        countries.add("Bohemian Waxwing");
        countries.add("Blue Jay");
        countries.add("Atlantic Puffin");
        countries.add("Keel-billed Toucan");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView countryRv=view.findViewById(R.id.countryRv);
        countryRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        CountryAdaptor adaptor =new CountryAdaptor(getActivity(),R.layout.row_country,countries);
        countryRv.setAdapter(adaptor);
    }
    class CountryAdaptor extends RecyclerView.Adapter<CountryAdaptor.Holder>{

        private final Context context;
        private final int layout;
        private final List<String> countries;
        private final LayoutInflater inflater;

        public CountryAdaptor(Context context, int layout, List<String> countries) {
            this.context = context;
            this.layout = layout;
            this.countries = countries;
            inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(layout,parent,false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            String countryName = countries.get(position);
            holder.textCountry.setText(countryName);
        }

        @Override
        public int getItemCount() {
            return countries.size();
        }

        class  Holder extends RecyclerView.ViewHolder{

            TextView textCountry;
            public Holder(@NonNull View itemView) {
                super(itemView);
                textCountry = itemView.findViewById(R.id.textCountry);
            }
        }
    }
}