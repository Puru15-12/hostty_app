package com.example.hostty.Resources.ECE;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hostty.R;
import com.example.hostty.Resources.CS.CSResourceDocs;
import com.example.hostty.Resources.CourseClass;

import java.util.ArrayList;
import java.util.List;

public class ECECourseAdapter extends BaseAdapter {
    private Context mContext;
    private List<CourseClass> courseList;


    ECECourseAdapter(Context context, ArrayList<CourseClass> arrayList) {
        this.mContext = context;
        this.courseList = arrayList;
    }



    public int getCount() {
        return courseList.size();
    }

    public Object getItem(int pos) {
        return courseList.get(pos);
    }


    public long getItemId(int i) {
        return i;
    }


    public View getView(final int i, View view, ViewGroup viewGroup) {


        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.course_ece_cell, viewGroup, false);
        }

        TextView courseNo=view.findViewById(R.id.course_ece_name);
        TextView courseName=view.findViewById(R.id.course_ece_no);

        final CourseClass course = courseList.get(i);

        courseNo.setText(course.getCourseNo());
        courseName.setText(course.getCourseName());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(mContext, ECEResourceDocs.class);
                intent.putExtra("eceCourseName",course.getCourseName());
                intent.putExtra("eceCourseNo",course.getCourseNo());
                mContext.startActivity(intent);

            }
        });
        return view;
    }
}
