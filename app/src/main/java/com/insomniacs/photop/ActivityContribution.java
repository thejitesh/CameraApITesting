package com.insomniacs.photop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.insomniacs.photop.utils.ContributorModel;

import java.util.ArrayList;

/**
 * Created by INSO18 on 05-04-2018.
 */

public class ActivityContribution extends AppCompatActivity {

    private RecyclerView rvContributors;
    private AdapterContribution adapterContribution;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribution);
        rvContributors = findViewById(R.id.rvContribution);
        adapterContribution = new AdapterContribution(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvContributors.setLayoutManager(layoutManager);
        setContributors();
        rvContributors.setAdapter(adapterContribution);
    }

    public void setContributors() {
        ArrayList<ContributorModel> contributorList = new ArrayList<>();
        ContributorModel contributorModel = new ContributorModel();
        contributorModel.name = "Jitesh Vartak";
        contributorModel.designation = "Senior Android Developer";
        contributorModel.resId = R.drawable.frame_an_sop;
        contributorList.add(contributorModel);
        ContributorModel contributorModel2 = new ContributorModel();
        contributorModel.name = "Varun Pandey";
        contributorModel2.designation = "Junior Android Developer";
        contributorModel2.resId = R.drawable.frame_sw;
        contributorList.add(contributorModel2);
        adapterContribution.setData(contributorList);
        adapterContribution.notifyDataSetChanged();

    }
}
