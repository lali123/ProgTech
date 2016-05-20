package hu.unideb.inf.lali123.model;

import hu.unideb.inf.lali123.Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class implements the HighScoreDAO interface.
 * 
 * Read and write to HighScore.xml file.
 * 
 * @author Lajos
 *
 */
public class HighScoreDAOIml implements HighScoreDAO {

    /**
     * Logger for logging.
     */
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    /* (non-Javadoc)
     * @see hu.unideb.inf.lali123.model.HighScoreDAO#addHighScore(hu.unideb.inf.lali123.model.HighScore)
     */
    @Override
    public void addHighScore(HighScore highScore) {

        // Creating listOfStates
        HighScores highScores = getAllHighScores();
        highScores.addHighScore(highScore);

        try {

            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(HighScores.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // for getting nice formatted output
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);

            URL resourceUrl = getClass().getResource("HighScores.xml");

            File file = new File(resourceUrl.toURI());
            OutputStream XMLfile = new FileOutputStream(file);
            System.out.println(XMLfile);
            jaxbMarshaller.marshal(highScores, XMLfile);
            XMLfile.close();
            logger.info("Add new HighScore " + highScore.getName());
        } catch (JAXBException e) {
            logger.error("JAXB Exception during marshalling.");
            // e.printStackTrace();
        } catch (IOException e) {
            logger.error("IO Exception during marshalling.");
            // e.printStackTrace();
        } catch (URISyntaxException e) {
            logger.error("URI Syntax Exception during marshalling.");
            // e.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see hu.unideb.inf.lali123.model.HighScoreDAO#getAllHighScores()
     */
    @Override
    public HighScores getAllHighScores() {
        HighScores highScores = new HighScores();

        try {
            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(HighScores.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            InputStream XMLfile = getClass().getResourceAsStream(
                    "HighScores.xml");

            highScores = (HighScores) jaxbUnmarshaller.unmarshal(XMLfile);
            XMLfile.close();

        } catch (JAXBException e) {
            logger.error("JAXB Exception during unmarshalling.");
            // e.printStackTrace();
        } catch (IOException e) {
            logger.error("IO Exception during unmarshalling.");
            // e.printStackTrace();
        }

        return highScores;
    }
}
