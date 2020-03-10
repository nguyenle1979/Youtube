package youtube.com.common;

import org.openqa.selenium.By;

public class ObjectMap {
	
/*===========================================================================
 * Web Elements of YouTube Menu.	
/*===========================================================================*/		
	public static By byYTMenuEntry_Menu	 			= By.cssSelector("yt-formatted-string[class='title style-scope ytd-guide-entry-renderer']");
	public static By byToolTip_Object 				= By.cssSelector("div[id='tooltip'][class='style-scope paper-tooltip fade-in-animation']");
	
/*===========================================================================
 * Web Elements of YouTube Home Page. 	
/*===========================================================================*/		
	public static By bySearchButton_Home 			= By.cssSelector("button[class='style-scope ytd-searchbox'][aria-label='Search']");
	public static By bySignInButton_Home			= By.cssSelector("paper-button[aria-label='Sign in']");
	public static By bySearchTextBox_Home 			= By.cssSelector("input[id='search']");
	public static By byListingVideoTitle_Home 		= By.cssSelector("yt-formatted-string[id='video-title'][class='style-scope ytd-rich-grid-video-renderer']");
	public static By byListingVideoThumb_Home 		= By.cssSelector("img[width='9999']");
	public static By byListingVideoChannelThumb_Home= By.cssSelector("img[class='style-scope yt-img-shadow'][width='48']");
	public static By byListingVideoChannelName_Home = By.cssSelector("a[class='yt-simple-endpoint style-scope yt-formatted-string']");
	public static By byCreateAVideoOrPostButton_Home= By.cssSelector("button[class='style-scope yt-icon-button'][aria-label='Create a video or post']");
	public static By byYouTubeAppsButton_Home 		= By.cssSelector("button[class='style-scope yt-icon-button'][aria-label='YouTube apps']");
	public static By byNotificationsButton_Home 	= By.cssSelector("button[class='style-scope yt-icon-button'][aria-label='Notifications']");
	
/*===========================================================================
 * Web Elements of YouTube Search Result Page. 	
/*===========================================================================*/		
	public static By byListingVideoTitle_SR	 		= By.cssSelector("yt-formatted-string[class='style-scope ytd-video-renderer']");
	
/*===========================================================================
 * Web Elements of YouTube Primary Video Page. 	
/*===========================================================================*/
	/*Video Control*/
	public static By byVideoTitle_Primary 			= By.cssSelector("yt-formatted-string[class='style-scope ytd-video-primary-info-renderer']");
	public static By byMainVideoContainer_Primary 	= By.cssSelector("video[class='video-stream html5-main-video']");
	public static By byYTChomeControl_Primary 		= By.cssSelector("div[class='ytp-chrome-controls']");
	public static By byUpNextVideoTitle_Primary 	= By.cssSelector("span[id='video-title'][class='style-scope ytd-compact-video-renderer']");
	public static By byViewCount_Primary			= By.cssSelector("yt-view-count-renderer[class='style-scope ytd-video-primary-info-renderer']");
	public static By byChannelName_Primary			= By.cssSelector("yt-formatted-string[class='style-scope ytd-channel-name']");
	public static By byNumberOfSubscriber_Primary 	= By.cssSelector("yt-formatted-string[class='style-scope ytd-video-owner-renderer']");
	public static By byPauseButton_Primary			= By.cssSelector("button[title='Pause (k)'][aria-label='Pause (k)']");
	public static By byPlayButton_Primary			= By.cssSelector("button[title='Play (k)'][aria-label='Play (k)']");
	public static By byNextButton_Primary			= By.cssSelector("a[class='ytp-next-button ytp-button'][role='button']");
	public static By byMuteButton_Primary			= By.cssSelector("button[ytp-mute-button ytp-button]");
	public static By bySubtitlesButton_Primary		= By.cssSelector("button[class='ytp-subtitles-button ytp-button']");
	public static By bySettingsButton_Primary		= By.cssSelector("button[class='ytp-button ytp-settings-button'][aria-label='Settings']");
	public static By bySettingsMenu_Primary			= By.cssSelector("div[class='ytp-panel-menu'][role='menu']");
	public static By bySettingsMenuItem_Primary 	= By.cssSelector("div[class='ytp-menuitem-label']");
	public static By byMiniPlayerButton_Primary		= By.cssSelector("button[class='ytp-miniplayer-button ytp-button']");
	public static By byTheaterModeButton_Primary	= By.cssSelector("button[class='ytp-size-button ytp-button']");
	public static By byPlayOnTVButton_Primary		= By.cssSelector("button[aria-label='Play on TV']");
	public static By byFullScreenButton_Primary		= By.cssSelector("button[class='ytp-fullscreen-button ytp-button']");
	public static By byLikeButton_Primary			= By.cssSelector("yt-formatted-string[class='style-scope ytd-toggle-button-renderer style-text'][aria-label$='likes']");
	public static By byDislikeButton_Primary		= By.cssSelector("yt-formatted-string[class='style-scope ytd-toggle-button-renderer style-text'][aria-label$='dislikes']");
	public static By byShareButton_Primary			= By.cssSelector("yt-icon-button[class='style-scope ytd-button-renderer style-default size-default']");
	public static By bySaveButton_Primary			= By.cssSelector("yt-formatted-string[class='style-scope ytd-button-renderer style-default size-default']");
	public static By byAutoPlayButton_Primary		= By.cssSelector("paper-toggle-button[class='style-scope ytd-compact-autoplay-renderer']");
	public static By bySubscribeButton_Primary		= By.cssSelector("div[id='subscribe-button'][class='style-scope ytd-video-secondary-info-renderer']");
	public static By byNumberOfComment_Primary		= By.cssSelector("yt-formatted-string[class='count-text style-scope ytd-comments-header-renderer']");
	public static By byCommentContentText_Primary	= By.cssSelector("yt-formatted-string[id='content-text'][class='style-scope ytd-comment-renderer']");
	public static By byAuthorOfComment_Primary		= By.cssSelector("span[class='style-scope ytd-comment-renderer']");
	public static By byReplyCommentButton_Primary	= By.cssSelector("paper-button[class='style-scope ytd-button-renderer style-text size-default'][aria-label='Reply']");
	public static By byLikeCommentButton_Primary	= By.cssSelector("button[class='style-scope yt-icon-button'][aria-label^='Like this comment']");
	public static By byViewReplyButton_Primary		= By.cssSelector("paper-button[class='style-scope ytd-button-renderer'][aria-label^='View']");
	public static By byHideReplyButton_Primary		= By.cssSelector("paper-button[class='style-scope ytd-button-renderer'][aria-label^='Hide']");
	public static By byLikeReplyButton_Primary		= By.cssSelector("button[class='style-scope yt-icon-button'][aria-label^='Like this reply']");
	public static By byAddCommentTextBox_Primary	= By.cssSelector("div[class='style-scope yt-formatted-string'][aria-label='Add a public comment...']");
	public static By byCommentButton_Primary		= By.cssSelector("paper-button[class='style-scope ytd-button-renderer style-primary size-default'][aria-label='Comment']");
	public static By byCancelButton_Primary			= By.cssSelector("paper-button[class='style-scope ytd-button-renderer style-text size-default'][aria-label='Cancel']");
	
	
	public static By byPlayListVideo_Primary 		= By.cssSelector("span[id='video-title'][class='style-scope ytd-playlist-panel-video-renderer']");
	public static By bySavePlayListButton_Primary 	= By.cssSelector("button[class='style-scope yt-icon-button'][aria-label='Save playlist']");
	public static By byLoopPlayListButton_Primary 	= By.cssSelector("button[class='style-scope yt-icon-button'][aria-label='Loop playlist']");
	public static By byShufflePlayListButton_Primary = By.cssSelector("button[class='style-scope yt-icon-button'][aria-label='Shuffle playlist']");

	
	/*More Actions Web Element*/
	public static By byMoreActionsButton_Primary	= By.cssSelector("button[aria-label='More actions']");
	public static By byMoreActionsList_Primary		= By.cssSelector("paper-listbox[class='style-scope ytd-menu-popup-renderer'][role='listbox']");
	public static By byReportItem_Primary			= By.cssSelector("paper-item[class='style-scope ytd-menu-navigation-item-renderer']");
	public static By byOpenTranscriptItem_Primary	= By.cssSelector("paper-item[class='style-scope ytd-menu-service-item-renderer']");
	public static By byAddTranslationsItem_Primary	= By.cssSelector("yt-icon[class='style-scope ytd-menu-navigation-item-renderer']");
	
	public static By bySortByMenuItem_Primary 		= By.cssSelector("div[class='item style-scope yt-dropdown-menu']");
	public static By bySortByButton_Primary			= By.xpath("//paper-button[@slot='dropdown-trigger'][@aria-label='Sort comments']");
	public static By bySortByList_Primary			= By.cssSelector("paper-listbox[class='dropdown-content style-scope yt-dropdown-menu'][slot='dropdown-content']");	
	public static By bySortByLabel_Primary			= By.cssSelector("div[class='style-scope yt-dropdown-menu'][id='icon-label']");
	
	/*Ads Web Element*/
	public static By bySkipAdButton_Primary			= By.cssSelector("button[class='ytp-ad-skip-button ytp-button']");
	public static By byAdsText_Primary				= By.cssSelector("div[class='ytp-ad-player-overlay-instream-info']");
	public static By byAdsReviewText_Primary		= By.cssSelector("div[class='ytp-ad-text ytp-ad-preview-text']");
	
	
/*===========================================================================
 * Web Elements of YouTube Pop-Up. 	
/*===========================================================================*/
	public static By byPromotion_PopUp				= By.cssSelector("div[id='main'][class='style-scope ytd-mealbar-promo-renderer']");
	public static By byGetItNowButton_PopUp			= By.cssSelector("paper-button[class='style-scope ytd-button-renderer style-blue-text size-default'][aria-label='Get it now']");
	public static By byNoThanksButton_PopUp			= By.cssSelector("paper-button[class='style-scope ytd-button-renderer style-text size-default'][aria-label='No thanks']");
	public static By byOkButton_PopUp				= By.cssSelector("paper-button[class='style-scope ytd-button-renderer style-blue-text size-default'][aria-label='Ok']");
	public static By byReviewButton_PopUp			= By.cssSelector("paper-button[class='style-scope ytd-button-renderer style-blue-text size-default'][aria-label='Review']");

	public static By bySurveyOption_PopUp			= By.cssSelector("yt-formatted-string[class='style-scope ytd-single-option-survey-option-renderer']");
	public static By bySurvey_PopUp					= By.cssSelector("ytd-single-option-survey-renderer[class='style-scope ytd-popup-container']");
	
/*===========================================================================
 * Web Elements of YouTube Trending Page. 	
/*===========================================================================*/
	public static By byVideoTitle_Trending			= By.cssSelector("yt-formatted-string[class='style-scope ytd-video-renderer'][aria-label$='views']");

/*===========================================================================
 * Web Elements of YouTube History Page. 	
/*===========================================================================*/
	public static By byHistoryTypeRadioButton_History			= By.xpath("//paper-radio-button[@class='style-scope ytd-sub-feed-option-renderer'][@role='radio']");
	public static By byClearAllWatchHistoryButton_History		= By.cssSelector("paper-button[class='style-scope ytd-button-renderer'][aria-label='Clear all watch history']");
	public static By byPauseWatchHistoryButton_History			= By.cssSelector("paper-button[class='style-scope ytd-button-renderer'][aria-label='Pause watch history']");
	public static By byManageAllAtivityButton_History			= By.cssSelector("paper-button[class='style-scope ytd-button-renderer size-default'][aria-label='Manage all activity']");
	public static By bySearchWatchHistoryInput_History			= By.cssSelector("input[class='style-scope paper-input'][name='query']");
	
}
