# DisscrollViewDemo
DisscrollViewDemo

``compile 'com.solarexsoft.disscrollview:disscrollview:1.0.0'``

Usage:

```
<?xml version="1.0" encoding="utf-8"?>
<com.solarexsoft.disscrollview.DisscrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:disscroll="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <com.solarexsoft.disscrollview.DisscrollLayout
        android:gravity="center"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="600dp"
            disscroll:disscroll_alpha="true"
            android:layout_margin="10dp"
            android:src="@drawable/hellokitty1"/>
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="15sp"
            android:gravity="center"
            android:textColor="@android:color/holo_purple"
            android:layout_margin="10dp"
            android:text="@string/intro"/>
        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/hellokitty2"
            android:layout_margin="10dp"
            android:scaleType="centerCrop"
            disscroll:disscroll_translation="fromBottom|fromRight"
            disscroll:disscroll_alpha="true"
            disscroll:disscroll_scaleX="true"
            disscroll:disscroll_scaleY="true"/>
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="15sp"
            android:gravity="center"
            android:text="@string/author"
            android:layout_margin="30dp"
            disscroll:disscroll_fromBgColor="@android:color/holo_blue_light"
            disscroll:disscroll_toBgColor="@android:color/holo_green_dark"/>
        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/hellokitty3"
            android:layout_gravity="center"
            android:layout_margin="10dp"
            android:scaleType="centerCrop"
            disscroll:disscroll_scaleX="true"
            disscroll:disscroll_scaleY="true"/>
        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/hellokitty4"
            android:layout_margin="10dp"
            android:scaleType="fitXY"
            disscroll:disscroll_alpha="true"
            disscroll:disscroll_translation="fromLeft|fromTop"/>
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="15sp"
            android:text="@string/history"
            android:gravity="center"
            android:layout_margin="30dp"
            disscroll:disscroll_translation="fromBottom|fromLeft"
            disscroll:disscroll_alpha="true"/>
        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/hellokitty5"
            android:layout_margin="10dp"
            android:scaleType="fitXY"
            disscroll:disscroll_translation="fromTop|fromRight"
            disscroll:disscroll_scaleX="true"
            disscroll:disscroll_scaleY="true"/>

    </com.solarexsoft.disscrollview.DisscrollLayout>

</com.solarexsoft.disscrollview.DisscrollView>
```

Detailed attributes see [attrs.xml](https://github.com/flyfire/DisscrollViewDemo/blob/master/disscrollview/src/main/res/values/attrs.xml)

Demo video on youtube:
<a href="http://www.youtube.com/watch?feature=player_embedded&v=piHcvWvSLiY
" target="_blank"><img src="http://img.youtube.com/vi/piHcvWvSLiY/0.jpg" width="560" height="315" border="10" /></a>
