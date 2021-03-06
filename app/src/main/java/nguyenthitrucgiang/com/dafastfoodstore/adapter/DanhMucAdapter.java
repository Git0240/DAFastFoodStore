package nguyenthitrucgiang.com.dafastfoodstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import nguyenthitrucgiang.com.dafastfoodstore.model.DanhMuc;

public class DanhMucAdapter extends ArrayAdapter<DanhMuc> {

	public DanhMucAdapter(Context context, int resource, List<DanhMuc> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}
@Override
public View getView(int position, View convertView, ViewGroup parent) {
	// TODO Auto-generated method stub
	View view = convertView;
	if (view ==null){
		LayoutInflater inflater = LayoutInflater.from(getContext());
		view = inflater.inflate(nguyenthitrucgiang.com.dafastfoodstore.R.layout.item_list_danhmuc, null);
	}
	DanhMuc dm = getItem(position);
	if(dm!=null){
		TextView txtTen = (TextView)view.findViewById(nguyenthitrucgiang.com.dafastfoodstore.R.id.tv_tend);
		TextView txtId = (TextView)view.findViewById(nguyenthitrucgiang.com.dafastfoodstore.R.id.tv_Idd);
		txtTen.setText(dm.getmTenDM());
		txtId.setText(String.valueOf(dm.getmMaDM()));
		
	}
	return view;
}

}
