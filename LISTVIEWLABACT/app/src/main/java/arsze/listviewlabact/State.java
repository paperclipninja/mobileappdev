package arsze.listviewlabact;

/**
 * Created by Arianna on 4/15/2015.
 */
public class State {
    public String stateName;
    public String cityName;
    public String temperature;

    public State(String name, String city, String temp)
    {
        stateName=name;
        cityName=city;
        temperature=temp;
    }
    public String getCity(){
        return cityName;
    }
    public String getState(){
        return stateName;
    }
    public String getTemp()
    {
        return temperature;
    }
    public void updateTemp(){
        //asynch task here
        //get info from
/*        GenericDownloader genericDownloader = new GenericDownloader() {
            @Override
            protected void onPostExecute(String result) {
                setText(result);
            }
        };
        genericDownloader.execute("http://www.yahoo.com/weather");
        get weather for the city
        update adapter
        */

    }
}
