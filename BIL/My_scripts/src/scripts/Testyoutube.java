/*package scripts;



import org.openqa.selenium.firefox.FirefoxDriver;

import Flash.FlashObjectWebDriver;

public class Testyoutube {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		 
		// This is seperate class which is available inside jar which i attached
//		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "movie_player");
		 
		 driver.get("https://www.youtube.com/watch?v=7igozQAdBMs");
		 Thread.sleep(2000L);
		 
		 // let the video load
		 while (Integer.parseInt(flashApp.callFlashObject("getPlayerState")) == 3){
		 Thread.sleep(1000L);
		 }
		 
		 // Play the video for 10 seconds
		 Thread.sleep(5000);
		 flashApp.callFlashObject("pauseVideo");
		 Thread.sleep(5000);
		 flashApp.callFlashObject("playVideo");
		 Thread.sleep(5000);
		 // Seek to is method which will forword video to 140 second
		 flashApp.callFlashObject("seekTo","140","true");
		 Thread.sleep(5000);
		 flashApp.callFlashObject("mute");
		 Thread.sleep(5000);
		 flashApp.callFlashObject("setVolume","50");
		 Thread.sleep(5000);

	}

}
*/