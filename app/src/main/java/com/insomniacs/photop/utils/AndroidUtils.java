package com.insomniacs.photop.utils;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;


/**
 * Created by insoapp1 on 08-08-2017.
 */

public class AndroidUtils {


    private final static String TAG = AndroidUtils.class.getSimpleName();

    public static void goneView(View view) {
        if (view != null) {
            view.setVisibility(View.GONE);
        }
    }

    public static boolean isVisible(View view) {
        return !(view == null || !view.isShown());
    }

    public static void hideView(View view) {
        if (view != null) {
            view.setVisibility(View.INVISIBLE);
        }
    }

    public static void showView(View view) {
        if (view != null) {
            view.setVisibility(View.VISIBLE);
        }
    }

    public static void setText(TextView textView, String string) {
        if (textView != null && !TextUtils.isEmpty(string)) {
            showView(textView);
            textView.setText(string.trim());
        }
    }

    public static void setTextGoneIfBlank(TextView textView, String string) {
        if (textView != null && string != null) {
            showView(textView);
            textView.setText(string.trim());
        } else {
            goneView(textView);
        }
    }

    public static void setTextInvisibleIfBlank(TextView textView, String string) {
        if (textView != null && string != null) {
            showView(textView);
            textView.setText(string.trim());
        } else {
            hideView(textView);
        }
    }

    public static void setBlankText(EditText textView) {
        if (textView != null) {
            showView(textView);
            textView.setText("");
        }
    }

    public static void setBlankText(TextView textView) {
        if (textView != null) {
            showView(textView);
            textView.setText("");
        }
    }

    public static void setText(TextView textView, Spannable string) {
        if (textView != null && string != null) {
            showView(textView);
            textView.setText(string);
        }
    }

    public static void setVisibility(View view, int visibility) {
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    public static void setHTMLText(TextView textView, String string) {
        if (textView != null && string != null) {
            showView(textView);
            textView.setText(getHtmlText(string.trim()));
        }
    }

    public static Spanned getHtmlText(String string) {
        Spanned spanned;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            spanned = Html.fromHtml(string, Html.FROM_HTML_MODE_COMPACT);
        } else {
            spanned = Html.fromHtml(string);
        }
        return spanned;
    }

    public static void setTextGonIfBlank(TextView textView, String string) {
        if (textView != null) {
            if (string != null && !string.trim().isEmpty()) {
                showView(textView);
                textView.setText(string.trim());
            } else {
                goneView(textView);
            }
        }
    }

    public static void setText(TextView textView, int string) {
        setText(textView, string + "");
    }


    public static void showToast(Context context, String string) {
        getToast(context, string).show();
    }

    public static void showToast(Toast toast) {
        if (toast != null) {
            toast.show();
        }
    }

    public static Toast getToast(Context context, String string) {
        return Toast.makeText(context, string, Toast.LENGTH_LONG);
    }

    public static boolean isToastVisible(Toast toast) {
        if (toast == null) {
            return false;
        }
        View view = toast.getView();
        if (view == null || !view.isShown()) {
            return false;
        }
        return true;
    }

    public static void setOnClickListener(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void setClickable(View view, boolean isClickable) {
        if (view != null) {
            view.setClickable(isClickable);
        }
    }


    public static void setTextColor(Context context, TextView textView, int color) {
        if (context != null && textView != null) {
            textView.setTextColor(ContextCompat.getColor(context, color));
        }
    }

    public static String getEditTextText(EditText editText) {
        if (editText == null || editText.getText() == null) {
            return "";
        }
        return editText.getText().toString().trim();
    }

    public static void clearFocus(EditText... editTexts) {
        if (editTexts != null) {
            for (EditText editText : editTexts) {
                clearFocus(editText);
            }
        }
    }

    public static void clearFocus(EditText editText) {
        if (editText != null) {
            editText.clearFocus();
        }
    }



    public static String getTextViewText(TextView textView) {
        if (textView == null || textView.getText() == null) {
            return "";
        }
        return textView.getText().toString();
    }

    public static void closeKeyBoard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static int getSpinnerSelectionIndex(Spinner spinner) {
        if (spinner == null) {
            return -1;
        }
        return spinner.getSelectedItemPosition();
    }



    public static void setImageBackground(ImageView img, int resID) {
        if (img != null) {
            try {
                img.setImageResource(resID);
            } catch (Exception e) {
                Log.d("", "Problem with setImageBackground for resId " + resID);
            }
        }
    }

    public static String getSingleStringFromJson(JSONObject jsonObject) {

        if (jsonObject == null) {
            return "";
        }
        String str = "";
        Iterator<String> iterator = jsonObject.keys();
        if (iterator == null) {
            return str;
        }

        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key != null) {
                JSONArray array = jsonObject.optJSONArray(key);
                if (array != null) {
                    for (int i = 0; i < array.length(); i++) {
                        String objectStr = array.optString(i);
                        if (objectStr != null) {
                            str += objectStr + "\n";
                        }
                    }
                }
            }
        }
        return str;
    }



    @SuppressLint("NewApi")
    private static void setStatusBarColorAbove21(Activity activity, int colorResID) {

        Window window = activity.getWindow();
        if (window != null) {
            try {
                window.setStatusBarColor(ContextCompat.getColor(activity, colorResID));//color res id may be invalid
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private static int resolveTransparentStatusBarFlag(Context ctx) {
        String[] libs = ctx.getPackageManager().getSystemSharedLibraryNames();
        String reflect = null;

        if (libs == null)
            return 0;

        final String SAMSUNG = "touchwiz";
        final String SONY = "com.sonyericsson.navigationbar";

        for (String lib : libs) {

            if (lib.equals(SAMSUNG)) {
                reflect = "SYSTEM_UI_FLAG_TRANSPARENT_BACKGROUND";
            } else if (lib.startsWith(SONY)) {
                reflect = "SYSTEM_UI_FLAG_TRANSPARENT";
            }
        }

        if (reflect == null)
            return 0;

        try {
            Field field = View.class.getField(reflect);
            if (field.getType() == Integer.TYPE) {
                return field.getInt(null);
            }
        } catch (Exception e) {
        }

        return 0;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void setTranslucentStatus(Window win, boolean on) {
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    public static ObjectAnimator getTranslationErrorAnimation(View view) {
        return ObjectAnimator.ofFloat(view, "translationX", 0, 25, -25, 25, -25, 15, -15, 6, -6, 0).setDuration(700);
    }





    public static int dpToPx(Context context, int dp) {

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static float getScreenPercentOfWidth(float percent) {
        return (getScreenWidth() * percent) / 100;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static float getScreenPercentOfHeight(float percent) {
        return (getScreenHeight() * percent) / 100;
    }

    public static int dpToPx(Context context, float dp) {

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int pxToDp(Context context, int px) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int getStatusBarHeightPixel(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }



    public static void inflateAndSetVisibilityView(View container, int viewId, int visibility) {
        if (container == null) {
            return;
        }
        View view = container.findViewById(viewId);
        setVisibility(view, visibility);
    }

    public static void inflateAndSetVisibilityView(Activity container, int viewId, int visibility) {
        if (container == null) {
            return;
        }
        View view = container.findViewById(viewId);
        setVisibility(view, visibility);
    }

    public static View inflateAndReturnView(Activity container, int viewId) {
        if (container == null) {
            return null;
        }
        return container.findViewById(viewId);
    }

    public static View inflateAndReturnView(Dialog container, int viewId) {
        if (container == null) {
            return null;
        }
        return container.findViewById(viewId);
    }

    public static View inflateAndReturnView(View container, int viewId) {
        if (container == null) {
            return null;
        }
        return container.findViewById(viewId);

    }

    public static void inflateAndSetVisibilityView(Dialog container, int viewId, int visibility) {
        if (container == null) {
            return;
        }
        View view = container.findViewById(viewId);
        setVisibility(view, visibility);
    }

    public static void enableTextViewLinkClick(TextView customTextView) {
        if (customTextView == null) {
            return;
        }
        Linkify.addLinks(customTextView, Linkify.WEB_URLS);
        customTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void loadWebViewData(WebView webView, String webText) {
        if (TextUtils.isEmpty(webText) || webView == null) {
            return;
        }
        String descriptionText = "<html><head><style type=\"text/css\">@font-face {font-family: MyFont; src: url(\"fonts/font.ttf\")} body {font-family: MyFont;font-size: medium; margin:0px; padding:0px; text-align: justify;}</style></head><body>";
        descriptionText += webText;
        descriptionText += "</body></html>";
        webView.loadDataWithBaseURL("file:///android_asset/", descriptionText, "text/html; charset=UTF-8", "utf-8", null);
    }

    public static void loadWebViewDataWithBg(WebView webView, String webText) {
        if (TextUtils.isEmpty(webText) || webView == null) {
            return;
        }
        String descriptionText = "<html><head><style type=\"text/css\">@font-face {font-family: MyFont; src: url(\"fonts/font.ttf\")} body {color: #FFFFFF ; background-color: #006cb5 ; font-family: MyFont;font-size: medium; margin:0px; padding:0px; text-align: justify;}</style></head><body>";

        descriptionText += webText;
        descriptionText += "</body></html>";
        webView.loadDataWithBaseURL("file:///android_asset/", descriptionText, "text/html; charset=UTF-8", "utf-8", null);
    }

    public static void loadWebViewDataWithCenterAlignment(WebView webView, String webText) {
        if (TextUtils.isEmpty(webText) || webView == null) {
            return;
        }
        String descriptionText = "<html><head><style type=\"text/css\">@font-face {font-family: MyFont; src: url(\"fonts/font.ttf\")} body {font-family: MyFont;font-size: medium; margin:0px; padding:0px; text-align: center;}</style></head><body>";
        descriptionText += webText;
        descriptionText += "</body></html>";
        webView.loadDataWithBaseURL("file:///android_asset/", descriptionText, "text/html; charset=UTF-8", "utf-8", null);
    }



    public static void setFocusFor(EditText editText, Context context) {
        if (editText == null || context == null) {
            return;
        }
        editText.requestFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
    }

    public static void showKeyboard(Activity activity) {
        try {
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void storeBitmap(final Bitmap bitmap, final String fileUniqueName) {
        if (!isExternalStorageWritable()) {
            Log.e(TAG, "External Storage is not Available or Writable!");
            return;
        }

        new AsyncTask<Void, Void, File>() {
            @Override
            protected File doInBackground(Void... params) {
                File file = null;
                try {
                    file = getOutputMediaFile(fileUniqueName);
                    file.createNewFile();
                    FileOutputStream ostream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                    ostream.close();
                } catch (Exception e) {
                    Log.e(TAG, "External Storage problem");
                    e.printStackTrace();
                }
                return file;
            }
        }.execute();
    }

    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public static File getOutputMediaFile(String fileUniqueName) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
                + "/Android/data/"
                + "com.insomniacs.raunak"
                + "/Files");

        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }
        // Create a media file name
        String mImageName = fileUniqueName + ".jpg";
        File mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
        return mediaFile;
    }


    public static String safelyConvertToString(Object o) {
        try {
            return (String) o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static JSONObject safelyConvertToJsonObject(Object o) {
        try {
            return (JSONObject) o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }

    public static JSONArray safelyConvertToJsonArray(Object o) {
        try {
            return (JSONArray) o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONArray();
    }

    public static JSONObject createJsonObject(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            return new JSONObject();
        }
    }

    public static JSONArray createJsonArray(String str) {
        try {
            return new JSONArray(str);
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    public static boolean optBoolean(JSONObject jsonObject, String key) {
        if (jsonObject == null) {
            return false;
        }

        return jsonObject.optBoolean(key);
    }

    public static JSONObject optJsonObj(JSONObject jsonObject, String key) {

        if (jsonObject == null || key == null) {
            return new JSONObject();
        }
        return jsonObject.optJSONObject(key);
    }

    public static JSONArray optJsonArray(JSONObject jsonObject, String key) {
        if (jsonObject == null || key == null) {
            return new JSONArray();
        }

        JSONArray array = jsonObject.optJSONArray(key);
        return array == null ? new JSONArray() : array;
    }

    public static JSONObject optJsonObjectAtIndex(JSONArray jsonArray, int index) {
        if (jsonArray == null || index < 0) {
            return new JSONObject();
        }
        JSONObject object = jsonArray.optJSONObject(index);
        return object == null ? new JSONObject() : object;
    }

    public static String optString(JSONObject jsonObject, String key) {
        if (jsonObject == null || key == null) {
            return "";
        }
        return jsonObject.optString(key);
    }

    public static String optStringAtIndex(JSONArray array, int index) {

        try {
            return array.optString(index);
        } catch (Exception e) {
            return "";
        }
    }

    public static int optInt(JSONObject object, String key) {

        try {
            return object.optInt(key);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void setBackgroundColor(Context context, View view, int colorResId) {
        if (context == null || view == null) {
            return;
        }
        view.setBackgroundColor(ContextCompat.getColor(context, colorResId));
    }




    public static String getDateInRequiredFormat(String mStringDate, String oldFormat, String newFormat) {


        try {
            String formatedDate = "";
            SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat);
            Date myDate = null;
            try {
                myDate = dateFormat.parse(mStringDate);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }

            SimpleDateFormat timeFormat = new SimpleDateFormat(newFormat);
            formatedDate = timeFormat.format(myDate);

            if (!TextUtils.isEmpty(formatedDate)) {
                return formatedDate;
            }

            return mStringDate;
        } catch (Exception e) {
            e.printStackTrace();
            return mStringDate;
        }
    }

    @SuppressLint("NewApi")
    public static String getRealPathFromURI_API19(Context context, Uri uri) {
        String filePath = "";
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String wholeID = DocumentsContract.getDocumentId(uri);
// Split at colon, use second item in the array
            String[] splits = wholeID.split(":");
            if (splits.length == 2) {
                String id = splits[1];

                String[] column = {MediaStore.Images.Media.DATA};
// where id is equal to
                String sel = MediaStore.Images.Media._ID + "=?";
                Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        column, sel, new String[]{id}, null);
                int columnIndex = cursor.getColumnIndex(column[0]);
                if (cursor.moveToFirst()) {
                    filePath = cursor.getString(columnIndex);
                }
                cursor.close();
            }
        } else {
            filePath = uri.getPath();
        }
        return filePath;
    }


    @SuppressLint("NewApi")
    public static String getRealPathFromURI_API11to18(Context context, Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        String result = null;

        CursorLoader cursorLoader = new CursorLoader(
                context,
                contentUri, proj, null, null, null);
        Cursor cursor = cursorLoader.loadInBackground();

        if (cursor != null) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            result = cursor.getString(column_index);
        }
        return result;
    }




    public static void disableEditText(EditText validationEditText) {
        validationEditText.setEnabled(false);
    }

    public static void enableEditText(EditText validationEditText) {
        validationEditText.setEnabled(false);
    }

    public static String getFormattedAmountStr(int amt, String format) {
        NumberFormat formatter = new DecimalFormat(format);
        return formatter.format(amt);
    }

    public static Drawable setTintColor(Drawable d, int color) {
        Drawable wrappedDrawable = DrawableCompat.wrap(d);
        DrawableCompat.setTint(wrappedDrawable, color);
        return wrappedDrawable;
    }

    public static void callIntent(Context context, String number) {
        Uri call = Uri.parse("tel:" + number);
        Intent callIntent = new Intent(Intent.ACTION_DIAL, call);
        context.startActivity(callIntent);
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int newWidth, int newHeight) {

        Bitmap scaledBitmap = Bitmap.createBitmap(newWidth, newHeight, Bitmap.Config.ARGB_8888);

        float scaleX = newWidth / (float) bitmap.getWidth();
        float scaleY = newHeight / (float) bitmap.getHeight();
        float pivotX = 0;
        float pivotY = 0;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(scaleX, scaleY, pivotX, pivotY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bitmap, 0, 0, new Paint(Paint.FILTER_BITMAP_FLAG));

        return scaledBitmap;
    }

    public static Drawable getImageDrawable(Context context, int drawable) {

        return context.getResources().getDrawable(drawable);
    }

    public static void setImageDrawable(Context context, Drawable drawable, ImageView imageView) {
        try {
            imageView.setImageDrawable(drawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}