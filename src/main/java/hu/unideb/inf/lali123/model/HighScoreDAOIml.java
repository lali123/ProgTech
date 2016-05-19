package hu.unideb.inf.lali123.model;

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

public class HighScoreDAOIml implements HighScoreDAO {

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
            jaxbMarshaller.marshal(highScores, System.out);
            XMLfile.close();

        } catch (JAXBException e) {
            // some exception occured
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

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
            // some exception occured
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return highScores;
    }

}
