import java.awt.image.BufferedImage;

/*The assets class is used to load in all necessary image files that will be used in the running of the game.
 Buffered images declared here will be called up for use in other classes. */
public class Assets {
//variable declaration of all images
	//background images
	public static BufferedImage bg, bg2, mainBg, helpBg, settingBg, craft1Bg, craft2Bg, endBg;
	//button related images
	public static BufferedImage playButton, settingButton, helpButton, backButton, quitButton, craft;
	public static BufferedImage yesPlay, yesSetting, yesHelp, yesQuit, forwardArrow;
	public static BufferedImage selectTheme, yesCraft, yesHint, yesHint2,yesTrash;
	//Miscellaneous images
	public static BufferedImage outfit, o1, o2, end1, end2, no;
	public static BufferedImage clickMail, inbox;
	//flower, bouquet, and card related images used in craft stations and game window
	public static BufferedImage plainRose, rose1, rose2;
	public static BufferedImage plainDaisie, daisie1, daisie2;
	public static BufferedImage plainLav, lav1, lav2;
	public static BufferedImage bq1, bq2, bq3, r1, r2, r3, s1, s2, s3;
	public static BufferedImage[] patch = new BufferedImage[6];
	public static BufferedImage[] craftCard = new BufferedImage[9];
	public static BufferedImage[] newOrder = new BufferedImage[7];
	public static BufferedImage[] blueRose = new BufferedImage[14];
	public static BufferedImage[] purpleRose = new BufferedImage[14];
	public static BufferedImage[] blueDaisie = new BufferedImage[14];
	public static BufferedImage[] purpleDaisie = new BufferedImage[14];
	public static BufferedImage[] blueLav = new BufferedImage[16];
	public static BufferedImage[] purpleLav = new BufferedImage[16];
	public static BufferedImage[] cardColour = new BufferedImage[3];
	public static BufferedImage[] cardShape = new BufferedImage[3];
	public static BufferedImage[] cardStamp = new BufferedImage[4];
	public static BufferedImage[] bqColour = new BufferedImage[3];
	public static BufferedImage[] bqRibbonColour = new BufferedImage[3];
	public static BufferedImage[] flower = new BufferedImage[3];
	public static BufferedImage[] fc = new BufferedImage[2];

	//initialized all assets for use in the game
	public static void init() {
		//loading all windows background images 
		bg = ImageLoad.loadImage("bg.png");
		bg2 = ImageLoad.loadImage("bg2.png");
		mainBg = ImageLoad.loadImage("mainbg.png");
		helpBg = ImageLoad.loadImage("helpbg.png");
		settingBg = ImageLoad.loadImage("settingbg.png");
		craft1Bg = ImageLoad.loadImage("craft1bg.png");
		craft2Bg = ImageLoad.loadImage("craft2bg.png");
		endBg = ImageLoad.loadImage("endscreen.png");
		//Related images to settings window
		outfit = ImageLoad.loadImage("whichoutfit.png");
		o1 = ImageLoad.loadImage("summer.png");
		o2 = ImageLoad.loadImage("winter.png");
		selectTheme = ImageLoad.loadImage("selecttheme.png");
		// Loading in home screen buttons
		playButton = ImageLoad.loadImage("playbutton.png");
		settingButton = ImageLoad.loadImage("settingbutton.png");
		helpButton = ImageLoad.loadImage("helpbutton.png");
		quitButton = ImageLoad.loadImage("quitbutton.png");
		yesPlay = ImageLoad.loadImage("yesplay.png");
		yesSetting = ImageLoad.loadImage("yessetting.png");
		yesHelp = ImageLoad.loadImage("yeshelp.png");
		yesQuit = ImageLoad.loadImage("yesquit.png");
		// Loading in miscellaneous buttons
		backButton = ImageLoad.loadImage("backbutton.png");
		forwardArrow = ImageLoad.loadImage("forwardarrow.png");
		no = ImageLoad.loadImage("nochange.png");
		// array declarations for animations
		//new order flashing animation
		newOrder[0] = null;
		newOrder[1] = ImageLoad.loadImage("a.png");
		newOrder[2] = ImageLoad.loadImage("b.png");
		newOrder[3] = ImageLoad.loadImage("c.png");
		newOrder[4] = ImageLoad.loadImage("d.png");
		newOrder[5] = ImageLoad.loadImage("e.png");
		newOrder[6] = ImageLoad.loadImage("f.png");
		// array for dipping rose blue animation
		blueRose[0] = ImageLoad.loadImage("1.png");
		blueRose[1] = ImageLoad.loadImage("2.png");
		blueRose[2] = ImageLoad.loadImage("3.png");
		blueRose[3] = ImageLoad.loadImage("4.png");
		blueRose[4] = ImageLoad.loadImage("5.png");
		blueRose[5] = ImageLoad.loadImage("6.png");
		blueRose[6] = ImageLoad.loadImage("7.png");
		blueRose[7] = ImageLoad.loadImage("8.png");
		blueRose[8] = ImageLoad.loadImage("9.png");
		blueRose[9] = ImageLoad.loadImage("10.png");
		blueRose[10] = ImageLoad.loadImage("11.png");
		blueRose[11] = ImageLoad.loadImage("12.png");
		blueRose[12] = ImageLoad.loadImage("12.png");
		blueRose[13] = ImageLoad.loadImage("12.png");
		// array for dipping purple rose animation
		purpleRose[0] = ImageLoad.loadImage("21.png");
		purpleRose[1] = ImageLoad.loadImage("22.png");
		purpleRose[2] = ImageLoad.loadImage("23.png");
		purpleRose[3] = ImageLoad.loadImage("24.png");
		purpleRose[4] = ImageLoad.loadImage("25.png");
		purpleRose[5] = ImageLoad.loadImage("26.png");
		purpleRose[6] = ImageLoad.loadImage("27.png");
		purpleRose[7] = ImageLoad.loadImage("28.png");
		purpleRose[8] = ImageLoad.loadImage("29.png");
		purpleRose[9] = ImageLoad.loadImage("30.png");
		purpleRose[10] = ImageLoad.loadImage("31.png");
		purpleRose[11] = ImageLoad.loadImage("32.png");
		purpleRose[12] = ImageLoad.loadImage("32.png");
		purpleRose[13] = ImageLoad.loadImage("32.png");
		// array for blue daisie animation
		blueDaisie[0] = ImageLoad.loadImage("61.png");
		blueDaisie[1] = ImageLoad.loadImage("62.png");
		blueDaisie[2] = ImageLoad.loadImage("63.png");
		blueDaisie[3] = ImageLoad.loadImage("64.png");
		blueDaisie[4] = ImageLoad.loadImage("65.png");
		blueDaisie[5] = ImageLoad.loadImage("66.png");
		blueDaisie[6] = ImageLoad.loadImage("67.png");
		blueDaisie[7] = ImageLoad.loadImage("68.png");
		blueDaisie[8] = ImageLoad.loadImage("69.png");
		blueDaisie[9] = ImageLoad.loadImage("70.png");
		blueDaisie[10] = ImageLoad.loadImage("71.png");
		blueDaisie[11] = ImageLoad.loadImage("72.png");
		blueDaisie[12] = ImageLoad.loadImage("72.png");
		blueDaisie[13] = ImageLoad.loadImage("72.png");
		// array for purple daisie animation
		purpleDaisie[0] = ImageLoad.loadImage("41.png");
		purpleDaisie[1] = ImageLoad.loadImage("42.png");
		purpleDaisie[2] = ImageLoad.loadImage("43.png");
		purpleDaisie[3] = ImageLoad.loadImage("44.png");
		purpleDaisie[4] = ImageLoad.loadImage("45.png");
		purpleDaisie[5] = ImageLoad.loadImage("46.png");
		purpleDaisie[6] = ImageLoad.loadImage("47.png");
		purpleDaisie[7] = ImageLoad.loadImage("48.png");
		purpleDaisie[8] = ImageLoad.loadImage("49.png");
		purpleDaisie[9] = ImageLoad.loadImage("50.png");
		purpleDaisie[10] = ImageLoad.loadImage("51.png");
		purpleDaisie[11] = ImageLoad.loadImage("52.png");
		purpleDaisie[12] = ImageLoad.loadImage("52.png");
		purpleDaisie[13] = ImageLoad.loadImage("52.png");
		// array for blue lavender animation
		blueLav[0] = ImageLoad.loadImage("81.png");
		blueLav[1] = ImageLoad.loadImage("82.png");
		blueLav[2] = ImageLoad.loadImage("83.png");
		blueLav[3] = ImageLoad.loadImage("84.png");
		blueLav[4] = ImageLoad.loadImage("85.png");
		blueLav[5] = ImageLoad.loadImage("86.png");
		blueLav[6] = ImageLoad.loadImage("87.png");
		blueLav[7] = ImageLoad.loadImage("88.png");
		blueLav[8] = ImageLoad.loadImage("89.png");
		blueLav[9] = ImageLoad.loadImage("90.png");
		blueLav[10] = ImageLoad.loadImage("91.png");
		blueLav[11] = ImageLoad.loadImage("92.png");
		blueLav[12] = ImageLoad.loadImage("93.png");
		blueLav[13] = ImageLoad.loadImage("94.png");
		// array for purple lavender animation
		purpleLav[0] = ImageLoad.loadImage("101.png");
		purpleLav[1] = ImageLoad.loadImage("102.png");
		purpleLav[2] = ImageLoad.loadImage("103.png");
		purpleLav[3] = ImageLoad.loadImage("104.png");
		purpleLav[4] = ImageLoad.loadImage("105.png");
		purpleLav[5] = ImageLoad.loadImage("106.png");
		purpleLav[6] = ImageLoad.loadImage("107.png");
		purpleLav[7] = ImageLoad.loadImage("108.png");
		purpleLav[8] = ImageLoad.loadImage("109.png");
		purpleLav[9] = ImageLoad.loadImage("110.png");
		purpleLav[10] = ImageLoad.loadImage("111.png");
		purpleLav[11] = ImageLoad.loadImage("112.png");
		purpleLav[12] = ImageLoad.loadImage("113.png");
		purpleLav[13] = ImageLoad.loadImage("114.png");
		// array for components of a card order
		//loading all possible card shapes
		cardShape[0] = ImageLoad.loadImage("cardshape1.png");
		cardShape[1] = ImageLoad.loadImage("cardshape2.png");
		cardShape[2] = ImageLoad.loadImage("cardshape3.png");
		//loading all possible card colours
		cardColour[0] = ImageLoad.loadImage("cardcolour1.png");
		cardColour[1] = ImageLoad.loadImage("cardcolour2.png");
		cardColour[2] = ImageLoad.loadImage("cardcolour3.png");
		//loading all possible card seals
		cardStamp[0] = ImageLoad.loadImage("cardstamp1.png");
		cardStamp[1] = ImageLoad.loadImage("cardstamp2.png");
		cardStamp[2] = ImageLoad.loadImage("cardstamp3.png");
		//loading all possible bouquet colours
		bqColour[0] = ImageLoad.loadImage("bqcolour1.png");
		bqColour[1] = ImageLoad.loadImage("bqcolour2.png");
		bqColour[2] = ImageLoad.loadImage("bqcolour3.png");
		//loading all possible ribbon colours
		bqRibbonColour[0] = ImageLoad.loadImage("ribboncolour1.png");
		bqRibbonColour[1] = ImageLoad.loadImage("ribboncolour2.png");
		bqRibbonColour[2] = ImageLoad.loadImage("ribboncolour3.png");
		//loading all possible flower types
		flower[0] = ImageLoad.loadImage("f1.png");
		flower[1] = ImageLoad.loadImage("f2.png");
		flower[2] = ImageLoad.loadImage("f3.png");
		//loading all possible flower colours
		fc[0] = ImageLoad.loadImage("fc1.png");
		fc[1] = ImageLoad.loadImage("fc2.png");
		// miscellaneous images
		clickMail = ImageLoad.loadImage("clickmail.png");
		inbox = ImageLoad.loadImage("inbox.png");
		craft = ImageLoad.loadImage("craft.png");
		yesCraft = ImageLoad.loadImage("yescraft.png");
		yesHint = ImageLoad.loadImage("yeshint.png");
		yesHint2 = ImageLoad.loadImage("hint2.png");
		yesTrash = ImageLoad.loadImage("trashall.png");
		//images used in craft station one
		plainRose = ImageLoad.loadImage("plainrose.png");
		rose1 = ImageLoad.loadImage("roseblue.png");
		rose2 = ImageLoad.loadImage("rosepurple.png");
		plainDaisie = ImageLoad.loadImage("plaindaisie.png");
		daisie1 = ImageLoad.loadImage("daisieblue.png");
		daisie2 = ImageLoad.loadImage("daisiepurple.png");
		plainLav = ImageLoad.loadImage("plainlav.png");
		lav1 = ImageLoad.loadImage("lavblue.png");
		lav2 = ImageLoad.loadImage("lavpurple.png");
		//images used in craft station two 
		bq1 = ImageLoad.loadImage("bq1.png");
		bq2 = ImageLoad.loadImage("bq2.png");
		bq3 = ImageLoad.loadImage("bq3.png");
		r1 = ImageLoad.loadImage("r1.png");
		r2 = ImageLoad.loadImage("r2.png");
		r3 = ImageLoad.loadImage("r3.png");
		patch[0] = ImageLoad.loadImage("brblue.png");
		patch[1] = ImageLoad.loadImage("brpurple.png");
		patch[2] = ImageLoad.loadImage("bdblue.png");
		patch[3] = ImageLoad.loadImage("bdpurple.png");
		patch[4] = ImageLoad.loadImage("blblue.png");
		patch[5] = ImageLoad.loadImage("blpurple.png");
		craftCard[0] = ImageLoad.loadImage("c1.png");
		craftCard[1] = ImageLoad.loadImage("c2.png");
		craftCard[2] = ImageLoad.loadImage("c3.png");
		craftCard[3] = ImageLoad.loadImage("c4.png");
		craftCard[4] = ImageLoad.loadImage("c5.png");
		craftCard[5] = ImageLoad.loadImage("c6.png");
		craftCard[6] = ImageLoad.loadImage("c7.png");
		craftCard[7] = ImageLoad.loadImage("c8.png");
		craftCard[8] = ImageLoad.loadImage("c9.png");
		s1 = ImageLoad.loadImage("c10.png");
		s2 = ImageLoad.loadImage("c11.png");
		s3 = ImageLoad.loadImage("c12.png");
		//images used for the end screen
		end1 = ImageLoad.loadImage("success.png");
		end2 = ImageLoad.loadImage("tryagain.png");

	}
}
