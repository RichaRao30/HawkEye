package com.ibm.monitoringdashboard.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ibm.monitoringdashboard.R;
import com.ibm.monitoringdashboard.charts.ChartActivation1;
import com.ibm.monitoringdashboard.charts.ChartActivation2;
import com.ibm.monitoringdashboard.charts.ChartRecharge1;
import com.ibm.monitoringdashboard.charts.ChartRecharge2;
import com.ibm.monitoringdashboard.tables.TableActivation1;
import com.ibm.monitoringdashboard.tables.TableActivation2;
import com.ibm.monitoringdashboard.tables.TableExchange1;
import com.ibm.monitoringdashboard.tables.TableExchange2;
import com.ibm.monitoringdashboard.tables.TableRecharge1;
import com.ibm.monitoringdashboard.tables.TableRecharge2;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private static final int[] TAB_TITLES_A = new int[]{R.string.tab_text_3, R.string.tab_text_4};

    private final Context mContext;
    private String mTag;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    public SectionsPagerAdapter(Context context, FragmentManager fm,String tag) {
        super(fm);
        mContext = context;
        mTag=tag;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        if(mTag!=null&&mTag.equalsIgnoreCase("ChartActivation")) {
            switch (position) {
                case 0:
                    fragment = new ChartActivation1();
                    break;
                case 1:
                    fragment = new ChartActivation2();
                    break;
            }
        }
        else if(mTag!=null&&mTag.equalsIgnoreCase("ChartRecharge")) {
                switch (position) {
                case 0:
                    fragment = new ChartRecharge1();
                    break;
                case 1:
                    fragment = new ChartRecharge2();
                    break;
            }
        }
        else if(mTag!=null&&mTag.equalsIgnoreCase("TableActivation")) {
            switch (position) {
                case 0:
                    fragment = new TableActivation1();
                    break;
                case 1:
                    fragment = new TableActivation2();
                    break;
            }
        }
        else if(mTag!=null&&mTag.equalsIgnoreCase("TableRecharge")) {
            switch (position) {
                case 0:
                    fragment = new TableRecharge1();
                    break;
                case 1:
                    fragment = new TableRecharge2();
                    break;
            }
        }
        else if(mTag!=null&&mTag.equalsIgnoreCase("TableExchange")) {
            switch (position) {
                case 0:
                    fragment = new TableExchange1();
                    break;
                case 1:
                    fragment = new TableExchange2();
                    break;
            }
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if((mTag!=null&&mTag.equalsIgnoreCase("ChartActivation"))||(mTag!=null&&mTag.equalsIgnoreCase("ChartRecharge")))
            return mContext.getResources().getString(TAB_TITLES[position]);
        else if(mTag!=null&&mTag.equalsIgnoreCase("TableActivation")||(mTag!=null&&mTag.equalsIgnoreCase("TableRecharge"))||(mTag!=null&&mTag.equalsIgnoreCase("TableExchange")))
            return mContext.getResources().getString(TAB_TITLES_A[position]);
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}