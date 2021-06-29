package nguyenthitrucgiang.com.dafastfoodstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import nguyenthitrucgiang.com.dafastfoodstore.R;
import nguyenthitrucgiang.com.dafastfoodstore.model.SanPham;

public class SPsaphetAdapter extends ArrayAdapter<SanPham>{

	public SPsaphetAdapter(Context context, int resource, List<SanPham> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}
@Override
public View getView(int position, View convertView, ViewGroup parent) {
	// TODO Auto-generated method stub
	
	View view = convertView;
	if (view==null){
		LayoutInflater inflater = LayoutInflater.from(getContext());
		view = inflater.inflate(R.layout.item_list_spsh, null);
	}
	SanPham sanpham = getItem(position);
	if (sanpham!=null){
		TextView txtTen = (TextView)view.findViewById(R.id.tv_shten);
		TextView txtSoluong = (TextView)view.findViewById(R.id.tv_shsl);
		txtTen.setText(sanpham.getmTenSP());
		txtSoluong.setText(String.valueOf(sanpham.getmSoLuong()));
	}
	return view;
}
}
