package entities;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gadi.app.R;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.internal.ViewToClickToExpand;
import it.gmariotti.cardslib.library.internal.base.BaseCard;
import it.gmariotti.cardslib.library.view.component.CardThumbnailView;

public class ExerciseCard extends Card{

	protected Exercise exCurrent;
	protected Context cContext;

	// Inner layout controls
	 protected TextView mExrcReps;
	 protected TextView mExrcSets;
     protected TextView mExrcRest;



	public ExerciseCard(Context context, Exercise exrc) {
		this(context, R.layout.exrc_inner_content, exrc);

	}

	public ExerciseCard(Context context, int innerLayout, Exercise exrc) {
		super(context, innerLayout);
		exCurrent = exrc;
		cContext = context;
        init();
    }

	private void init() {
		CardHeader header = new CardHeader(cContext, R.layout.exrc_inner_header);

        //Set the header title
        header.setTitle(exCurrent.sName);
        //header.setOtherButtonVisible(true);
        //Add a popup menu. This method set OverFlow button to visible

        header.setPopupMenu(R.menu.card_popup, new CardHeader.OnClickCardHeaderPopupMenuListener() {
            @Override
            public void onMenuItemClick(BaseCard card, MenuItem item) {
                Toast.makeText(cContext, "Click on " + item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

//        header.setOtherButtonClickListener(new CardHeader.OnClickCardHeaderOtherButtonListener() {
//            @Override
//            public void onButtonItemClick(Card card, View view) {
//                //Example to change dinamically the button resources
//                card.getCardHeader().setOtherButtonDrawable(R.drawable.card_menu_button_other_add);
//                card.getCardView().refreshCard(card);
//            }
//        });
        addCardHeader(header);

        // Set thumb
        CardThumbnail thumbnail = new CardThumbnail(cContext);
        thumbnail.setDrawableResource(MuscleGroup.getThumb(exCurrent.muscleGroup));

        addCardThumbnail(thumbnail);

        CardExpand expand = new CardExpand(cContext);
        expand.setTitle("dada");
        //Set inner title in Expand Area
        addCardExpand(expand);



	}

	public void setupInnerViewElements(ViewGroup parent, View view) {

        //Retrieve elements
		mExrcRest = (TextView) parent.findViewById(R.id.exrc_card_rest);
		mExrcReps = (TextView) parent.findViewById(R.id.exrc_card_reps);
		mExrcSets = (TextView) parent.findViewById(R.id.exrc_card_sets);

		// Set Thumb
        ImageView img = (ImageView) parent.findViewById(R.id.exrc_card_check_btn);
        img.setImageResource(R.drawable.btn_check);
        img.setClickable(true);
//        img.setOnClickListener(new ImageView.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(cContext, "test", 2);
//            }
//        });

		// Set Texts
		mExrcReps.setText(exCurrent.nReps.toString() + " חזרות");
		mExrcSets.setText(exCurrent.nSets.toString() + " סטים");
        mExrcRest.setText("מנוחה");

        ViewToClickToExpand viewToClickToExpand = ViewToClickToExpand.builder().setupView(getCardView());
        setViewToClickToExpand(viewToClickToExpand);

        setOnExpandAnimatorEndListener(new OnExpandAnimatorEndListener() {
            @Override
            public void onExpandEnd(Card card) {
                Toast.makeText(cContext, "test", 2);
            }
        });


	}

    @Override
    public void onCollapseEnd() {
        super.onCollapseEnd();
    }

    @Override
    public void onExpandEnd() {
        super.onExpandEnd();
    }
}
