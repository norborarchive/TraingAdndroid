package com.thjug.hello.facade;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.thjug.hello.entity.Comment;
import com.thjug.hello.util.DBUtil;
import java.util.LinkedList;
import java.util.List;

public final class CommentFacade {

	private static final String TAG = "CommentFacade";

	private SQLiteDatabase database;
	private DBUtil dbHelper;
	private String[] allColumns = { DBUtil.COLUMN_ID, DBUtil.COLUMN_COMMENT };

	public CommentFacade(final Context context) {
		dbHelper = new DBUtil(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Comment createComment(final String comment) {
		final ContentValues values = new ContentValues();
		values.put(DBUtil.COLUMN_COMMENT, comment);
		final long insertId = database.insert(DBUtil.TABLE_COMMENTS, null, values);
		final Cursor cursor = database.query(DBUtil.TABLE_COMMENTS,
				allColumns, DBUtil.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		final Comment newComment = cursorToComment(cursor);
		cursor.close();
		return newComment;
	}

	public void deleteComment(final Comment comment) {
		final long id = comment.getId();
		Log.d(TAG, "Comment deleted with id: " + id);
		database.delete(DBUtil.TABLE_COMMENTS, DBUtil.COLUMN_ID + " = " + id, null);
	}

	public List<Comment> getAllComments() {
		final List<Comment> comments = new LinkedList<Comment>();

		final Cursor cursor = database.query(DBUtil.TABLE_COMMENTS, allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			final Comment comment = cursorToComment(cursor);
			comments.add(comment);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return comments;
	}

	private Comment cursorToComment(final Cursor cursor) {
		final Comment comment = new Comment();
		comment.setId(cursor.getLong(0));
		comment.setComment(cursor.getString(1));
		return comment;
	}

}
