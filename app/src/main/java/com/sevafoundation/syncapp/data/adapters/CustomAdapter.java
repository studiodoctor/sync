package com.sevafoundation.syncapp.data.adapters;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.sevafoundation.syncapp.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<String> list;
    private Context mCtx;
    private static String POPUP_CONSTANT = "mPopup";
    private static String POPUP_FORCE_SHOW_ICON = "setForceShowIcon";

    public CustomAdapter(List<String> list, Context mCtx) {
        this.list = list;
        this.mCtx = mCtx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CustomAdapter.ViewHolder holder, int position) {
        holder.textViewHead.setText("Hello from " + position);
        holder.textViewDesc.setText("Hello from " + position);

        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                PopupMenu popup = new PopupMenu(mCtx, view);
//                try {
//                    // Reflection apis to enforce show icon
//                    Field[] fields = popup.getClass().getDeclaredFields();
//                    for (Field field : fields) {
//                        if (field.getName().equals(POPUP_CONSTANT)) {
//                            field.setAccessible(true);
//                            Object menuPopupHelper = field.get(popup);
//                            Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
//                            Method setForceIcons = classPopupHelper.getMethod(POPUP_FORCE_SHOW_ICON, boolean.class);
//                            setForceIcons.invoke(menuPopupHelper, true);
//                            break;
//                        }
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
//                //popup.setOnMenuItemClickListener(mCtx);
//                popup.show();
                PopupWindow popupWindow;
                LayoutInflater layoutInflater = (LayoutInflater) mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View popupView = layoutInflater.inflate(R.layout.popup, null);

                popupWindow = new PopupWindow(
                        popupView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        //TODO do sth here on dismiss
                    }
                });

                popupWindow.showAsDropDown(view);

            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView buttonViewOption;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            buttonViewOption = (TextView) itemView.findViewById(R.id.textViewOptions);
        }
    }
}
