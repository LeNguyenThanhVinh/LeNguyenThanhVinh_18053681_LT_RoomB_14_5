package com.example.roomb;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomb.database.UserDatabase;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private ArrayList<Student> mStudents;
    private ItemClickListener listener ;
    public interface ItemClickListener{
        void onClickDelete(Student student);
    }
    public void setOnItemClick(ItemClickListener listner){
        listner = listener;
    }

    public StudentAdapter(ArrayList<Student> mStudents, ItemClickListener listener) {
        this.mStudents = mStudents;
        this.listener = listener;
    }

    @NonNull
    @Override
    public com.example.roomb.StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View heroView = inflater.inflate(R.layout.itemstudnet, parent, false);
        return new ViewHolder(heroView);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.roomb.StudentAdapter.ViewHolder holder, int position) {
        final Student student= mStudents.get(position);
        holder.txtDiaChi.setText(mStudents.get(position).getId()+". "+ mStudents.get(position).getAddress());

        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickDelete(student);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtDiaChi;
        Button btnSua, btnXoa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDiaChi = itemView.findViewById(R.id.txtDiaChi);
            btnSua = itemView.findViewById(R.id.btnSua);
            btnXoa = itemView.findViewById(R.id.btnXoa);

        }

    }

}
