package com.example.peter.planb_for_final_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyExpandableListAdapterCategorySearch extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<ParentRowCategorySearch> parentRowList;
    private ArrayList<ParentRowCategorySearch> originalList;

    public MyExpandableListAdapterCategorySearch(Context context,
                                              ArrayList<ParentRowCategorySearch> originalList) {
        this.context = context;
        this.parentRowList = new ArrayList<>();
        this.parentRowList = parentRowList;
        this.originalList = new ArrayList<>();
        this.originalList = originalList;
    }

    @Override
    public int getGroupCount() {
        return parentRowList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return parentRowList.get(groupPosition).getChildList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentRowList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return parentRowList.get(groupPosition).getChildList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition,
                             boolean isExpanded,
                             View convertView,
                             ViewGroup parent) {
        ParentRowCategorySearch parentRow = (ParentRowCategorySearch) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.parentcategory_row, null);
        }

        TextView heading = (TextView) convertView.findViewById(R.id.parent_text);

        heading.setText(parentRow.getName().trim());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition,
                             int childPosition,
                             boolean isLastChild,
                             View convertView,
                             ViewGroup parent) {
        ChildRowCategorySearch childRow
                = (ChildRowCategorySearch) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layourInflater = (LayoutInflater)
                    context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layourInflater.inflate(R.layout.childcategory_row, null);
        }

        ImageView childIcon = (ImageView) convertView.findViewById(R.id.child_icon);
        childIcon.setImageResource(R.drawable.ic_action_name);

        final TextView childText = (TextView) convertView.findViewById(R.id.child_text);
        childText.setText(childRow.getText().trim());

        final View finalConvertView = convertView;
        childText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(finalConvertView.getContext()
                        , childText.getText()
                        , Toast.LENGTH_SHORT).show();
            }
        });

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击空白处
                Intent intent = new Intent(finalConvertView.getContext(), Category.class);
                finalConvertView.getContext().startActivity(intent);
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query) {
        query = query.toLowerCase();
        parentRowList.clear();

        if (query.isEmpty()) {
            parentRowList.addAll(originalList);
        }
        else {
            for (ParentRowCategorySearch parentRow : originalList) {
                ArrayList<ChildRowCategorySearch> childList = parentRow.getChildList();
                ArrayList<ChildRowCategorySearch> newList = new ArrayList<ChildRowCategorySearch>();

                for (ChildRowCategorySearch childRow : childList) {
                    if (childRow.getText().toLowerCase().contains(query)) {
                        newList.add(childRow);
                    }
                } // end for (ChildRowCategrySearch childRow: childList)
                if (newList.size() > 0) {
                    ParentRowCategorySearch nParentRow = new ParentRowCategorySearch(parentRow.getName(),
                            newList);
                    parentRowList.add(nParentRow);
                }
            }// end or (ParentRow parentRow : originalList)
        } // end else

        notifyDataSetChanged();
    }
}
