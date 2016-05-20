package hu.unideb.inf.lali123.model;

import hu.unideb.inf.lali123.Main;
import javafx.beans.property.SimpleStringProperty;

import javax.xml.bind.annotation.XmlElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@XmlType(propOrder = { "name", "score", "date" })
/**
 * This class store data about winner of a match.
 * 
 * @author Lajos
 *
 */
public class HighScore {
    private SimpleStringProperty name;
    private SimpleStringProperty score;
    private SimpleStringProperty date;

    /**
     * Logger for logging.
     */
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public String getDate() {
        return date.get();
    }

    @XmlElement
    public void setDate(String date) {
        this.date.set(date);
    }

    public String getScore() {
        return score.get();
    }

    @XmlElement
    public void setScore(String score) {
        this.score.set(score);
        ;
    }

    public String getName() {
        return name.get();
    }

    @XmlElement
    public void setName(String name) {
        this.name.set(name);
    }

    public HighScore(String name, String score, String date) {
        super();
        this.name = new SimpleStringProperty();
        this.score = new SimpleStringProperty();
        this.date = new SimpleStringProperty();
        this.name.set(name);
        this.score.set(score);
        this.date.set(date);
        logger.info("HighScore created.");
    }
    
    public HighScore(){
        this.name = new SimpleStringProperty();
        this.score = new SimpleStringProperty();
        this.date = new SimpleStringProperty();
        logger.info("HighScore created.");
    }
}
