package com.example.booking_hotel_owner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booking_hotel_owner.Model.BookingModel;
import com.example.booking_hotel_owner.Model.Room;
import com.example.booking_hotel_owner.activity.AcceptChecking;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recyclerview_booking extends RecyclerView.Adapter<Recyclerview_booking.ViewHolder> {
    @NonNull
    private Context mcontext;
    ArrayList<BookingModel> list;
    ArrayList<BookingModel> filterList;

    TiengViet xuLyChuoiTiengViet = new TiengViet();

    public Recyclerview_booking(Context mcontext, ArrayList<BookingModel> list) {
        this.mcontext = mcontext;
        this.filterList = list;
        this.list = list;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_load_history_booking, parent, false);
        return new ViewHolder(view);
    }

    public Filter getFilter() {
        return filter;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String url = filterList.get(position).getIqr();
        Picasso.get().load(url).into(holder.imvHSP);
        holder.txtTSP.setText(filterList.get(position).getIdbooking());
      //  holder.Gia.setText(filterList.get(position).getDescription());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(mcontext, AcceptChecking.class);
              intent.putExtra("id", filterList.get(position).getIdbooking());
//                intent.putExtra("tenks", filterList.get(position).getIdHotelNavigation().getHotelName());
//                intent.putExtra("mota", filterList.get(position).getDescription());
//                intent.putExtra("diachi", filterList.get(position).getIdHotelNavigation().getAddress());
//                intent.putExtra("hinh", filterList.get(position).getImage());
//                intent.putExtra("idroom", filterList.get(position).getIdroom());
//                intent.putExtra("idhotel", filterList.get(position).getIdHotelNavigation().getIdhotel());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Object coordinatorlayout;
        ImageView imvHSP;
        TextView txtTSP, Gia, Khuvuc;
        CoordinatorLayout t;
        CardView cardView;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvHSP = itemView.findViewById(R.id.img_qr);
            txtTSP = itemView.findViewById(R.id.txt_hotelName);
           // Gia = itemView.findViewById(R.id.item_mota_diadiem);

            cardView = itemView.findViewById(R.id.boking);
        }
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            /// kh???i t???o bi???n result
            FilterResults filterResults = new FilterResults();
            String keySearch = constraint.toString();
            /// khi keysearch co gia tri
            if (keySearch != null && keySearch.toString().length() > 0) {
                /// th?? m??nh kh???i t???o list tr???ng ????? add d??? li???u sao khi check v??o
                ArrayList<BookingModel> filteredList = new ArrayList<>();
                String pattrn = keySearch.toLowerCase().trim();
                for (BookingModel item : list) {
                    /// check d??? li???u ????? add
                    if (xuLyChuoiTiengViet.ConvertString(item.getIdbooking().toLowerCase())
                            .contains(xuLyChuoiTiengViet.ConvertString(pattrn))) {
                        filteredList.add(item);
                    }
                }
                /// g??n v??o gi?? tr??? sao khi check xong
                filterResults.values = filteredList;
                filterResults.count = filteredList.size();
            } else {
                /// g??n l???i gi?? tr??? all
                filterResults.values = list;
                filterResults.count = list.size();
//                synchronized (list) {
//                    filterResults.values = list;
//                    filterResults.count = list.size();
//                }
            }
            return filterResults;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filterList = (ArrayList<BookingModel>) results.values;
            notifyDataSetChanged();
        }
    };
}
