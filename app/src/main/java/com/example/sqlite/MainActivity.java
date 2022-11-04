package com.example.sqlite;

import java.util.Locale;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

	Button btnCreateDatabase=null;
	Button btnInsertCategory=null;
	Button btnShowCategoryList=null;
	Button btnTransaction=null;
	Button btnShowDetail=null;
	Button btnInsertComputer=null;
	public static final int OPEN_AUTHOR_DIALOG=1;
	public static final int SEND_DATA_FROM_AUTHOR_ACTIVITY=2;
	SQLiteDatabase database=null;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.example.sqlite.R.layout.activity_main);
		btnInsertCategory=(Button) findViewById(R.id.btnInsertCategory);
		btnInsertCategory.setOnClickListener(new MyEvent());
		btnShowCategoryList=(Button) findViewById(R.id.buttonShowCategoryList);
		btnShowCategoryList.setOnClickListener(new MyEvent());
		btnInsertComputer=(Button) findViewById(R.id.buttonInsertComputer);
		btnInsertComputer.setOnClickListener(new MyEvent());
		getDatabase();
	}

	public boolean isTableExists(SQLiteDatabase database, String tableName) {
		Cursor cursor = database.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '"+tableName+"'", null);
		if(cursor!=null) {
			if(cursor.getCount()>0) {
				cursor.close();
				return true;
			}
			cursor.close();
		}
		return false;
	}

	public SQLiteDatabase getDatabase()
	{
		try
		{
			database=openOrCreateDatabase("mydata.db", Context.MODE_PRIVATE, null);
			if(database!=null)
			{
				if(isTableExists(database,"tblAuthors"))
					return database;
				database.setLocale(Locale.getDefault());
				database.setVersion(1);
				String sqlAuthor="create table tblAuthors ("
						+"id integer primary key autoincrement,"
						+"firstname text, "
						+"lastname text)";
				database.execSQL(sqlAuthor);
				String sqlBook="create table tblBooks ("
						+"id integer primary key autoincrement,"
						+"title text, "
						+"dateadded date,"
						+"authorid integer not null constraint authorid references tblAuthors(id) on delete cascade)";
				database.execSQL(sqlBook);
				//Cách tạo trigger khi nhập dữ liệu sai ràng buộc quan hệ
				String sqlTrigger="create trigger fk_insert_book before insert on tblBooks "
						+" for each row "
						+" begin "
						+" 	select raise(rollback,'them du lieu tren bang tblBooks bi sai') "
						+" 	where (select id from tblAuthors where id=new.authorid) is null ;"
						+" end;";
				database.execSQL(sqlTrigger);
				Toast.makeText(MainActivity.this, "OK OK", Toast.LENGTH_LONG).show();
			}
		}
		catch(Exception e)
		{
			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}
		return database;
	}
	public void createDatabaseAndTrigger()
	{
		if(database==null)
		{
			getDatabase();
			Toast.makeText(MainActivity.this, "OK OK", Toast.LENGTH_LONG).show();
		}
	}

	public void showInsertAuthorDialog()
	{
		Intent intent=new Intent(MainActivity.this, CreateCategoryActivity.class);
		startActivityForResult(intent, OPEN_AUTHOR_DIALOG);
	}

	public void showAuthorList1()
	{
		Intent intent=new Intent(MainActivity.this, ShowListCategoryActivity.class);
		startActivity(intent);
	}

	public void showAuthorList2()
	{
		Intent intent=new Intent(MainActivity.this, ShowListCategoryActivity2.class);
		startActivity(intent);
	}

	public void interactDBWithTransaction()
	{
		if(database!=null)
		{
			database.beginTransaction();
			try
			{

				ContentValues values=new ContentValues();
				values.put("firstname", "xx");
				values.put("lastname", "yyy");
				database.insert("tblAuthors", null, values);
				database.delete("tblAuthors", "ma=?", new String[]{"x"});

				database.setTransactionSuccessful();
			}
			catch(Exception ex)
			{
				Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
			}
			finally
			{
				database.endTransaction();
			}
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==SEND_DATA_FROM_AUTHOR_ACTIVITY)
		{
			Bundle bundle= data.getBundleExtra("DATA_AUTHOR");
			String firstname=bundle.getString("firstname");
			String lastname=bundle.getString("lastname");
			ContentValues content=new ContentValues();
			content.put("firstname", firstname);
			content.put("lastname", lastname);
			if(database!=null)
			{
				long authorid=database.insert("tblAuthors", null, content);
				if(authorid==-1)
				{
					Toast.makeText(MainActivity.this,authorid+" - "+ firstname +" - "+lastname +" ==> insert error!", Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(MainActivity.this, authorid+" - "+firstname +" - "+lastname +" ==>insert OK!", Toast.LENGTH_LONG).show();
				}
			}

		}
	}

	private class MyEvent implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v.getId()==R.id.btnInsertCategory)
			{
				showInsertAuthorDialog();
			}
			else if(v.getId()==R.id.buttonShowCategoryList)
			{
				showAuthorList1();
			}

			else if(v.getId()==R.id.buttonInsertComputer)
			{
				Intent intent=new Intent(MainActivity.this, InsertComputerActivity.class);
				startActivity(intent);
			}
		}

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_simple_database_main, menu);
		return true;
	}
}
