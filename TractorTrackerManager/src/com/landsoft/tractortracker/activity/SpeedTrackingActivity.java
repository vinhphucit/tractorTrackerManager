package com.landsoft.tractortracker.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewDataInterface;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.landsoft.tractortracker.R;

public class SpeedTrackingActivity extends BaseDialogActivity {

	public SpeedTrackingActivity() {
	}

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setDialogTitle(R.string.speed_tracker_title);
		RelativeLayout relativelayout = (RelativeLayout) ((LayoutInflater) getSystemService("layout_inflater"))
				.inflate(R.layout.wrapper_speed_tracker, null);
		addContentView(relativelayout);
		drawGraph();
	}

	private void drawGraph() {
		GraphViewSeries exampleSeries = new GraphViewSeries(
				new ServerTemperature[] { new ServerTemperature(1, 20),
						new ServerTemperature(2, 22),
						new ServerTemperature(3, 21),
						new ServerTemperature(4, 28),
						new ServerTemperature(5, 31) });

		// graph with dynamically genereated horizontal and vertical labels
		GraphView graphView;
		graphView = new LineGraphView(this // context
				, "LineGrahView" // heading
		);
		graphView.addSeries(exampleSeries); // data

		LinearLayout layout = (LinearLayout) findViewById(R.id.speed_tracker_graph);
		layout.addView(graphView);

		// graph with custom labels and drawBackground
		graphView = new LineGraphView(this, "LineGraphView");
		((LineGraphView) graphView).setDrawBackground(true);
		((LineGraphView) graphView).setBackgroundColor(Color.rgb(80, 30, 30));
	}

	static public class ServerTemperature implements GraphViewDataInterface {
		private final int day;
		private final int temp;

		public ServerTemperature(int day, int temp) {
			this.day = day;
			this.temp = temp;
		}

		@Override
		public double getX() {
			return day / 5d; // just return something
		}

		@Override
		public double getY() {
			return temp + 5d; // just return something
		}
	}
}
