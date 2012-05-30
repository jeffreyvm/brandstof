package be.jeffreyvanmulem.brandstof;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 6/05/12
 * Time: 23:01
 * To change this template use File | Settings | File Templates.
 */

import be.jeffreyvanmulem.brandstof.dao.interfaces.CarDao;
import be.jeffreyvanmulem.brandstof.dao.interfaces.FillupDao;
import be.jeffreyvanmulem.brandstof.dao.interfaces.UserDao;
import be.jeffreyvanmulem.brandstof.dao.interfaces.types.ColorDao;
import be.jeffreyvanmulem.brandstof.dao.interfaces.types.MakeDao;
import be.jeffreyvanmulem.brandstof.dao.interfaces.types.ModelDao;
import be.jeffreyvanmulem.brandstof.model.Car;
import be.jeffreyvanmulem.brandstof.model.Make;
import be.jeffreyvanmulem.brandstof.model.Model;
import be.jeffreyvanmulem.brandstof.model.User;
import be.jeffreyvanmulem.brandstof.model.types.Color;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataInitialiser {

    private static String[] dummySurNames = {"Heather", "Candice", "Angelina", "Megan"};
    private static String[] dummyNames = {"Huntington", "Swaenepoel", "Jolie", "Fox"};

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    private UserDao userDao;
    @Autowired
    private ColorDao colorDao;
    @Autowired
    private ModelDao modelDao;
    @Autowired
    private MakeDao makeDao;
    @Autowired
    private CarDao carDao;
    @Autowired
    private FillupDao fillupDao;

    @Transactional
    public void dataInit() {
        initColors();
        initUsers();
        initCars();
        initFillups();
        initMakes();
        initModels();
    }

    @Transactional
    private void initColors() {
        Color color = new Color();
        color.setHexCode("#000000");
        color.setCode("WHITE");
        colorDao.persist(color);
    }

    private void initMakes() {
        Make make = new Make();
        make.setName("Audi");
        makeDao.persist(make);
    }

    private void initModels() {
        Model model = new Model();
        //TODO: named query find make by name
        model.setMake(makeDao.findAll().iterator().next());
        model.setName("A1");
        modelDao.persist(model);
    }

    private void initUsers() {
        User user = new User();
        user.setUsername("jeffrey1988");
        user.setPassword("test123");
        user.setSurName("Jeffrey");
        user.setName("Van Mulem");
        user.setDateOfBirth(new LocalDate(1988, 03, 16));
        user.setEmail("jeffreyvanmulem@gmail.com");
        userDao.persist(user);
    }

    private void initCars() {
        Car car = new Car();
        //TODO: find model by name + make
        car.setModel(modelDao.findAll().iterator().next());
        //TODO: find color by name
        car.setColor(colorDao.findAll().iterator().next());
        car.setUser(userDao.findAll().iterator().next());
        car.setEngineSize(1.6f);
        carDao.persist(car);
    }

    private void initFillups() {
        Car car = carDao.findAll().iterator().next();
        try {
            InputStream inp = new FileInputStream("data/verbruiksdata.xls");

            HSSFWorkbook wb = new HSSFWorkbook(inp);
            HSSFSheet sheet = wb.getSheetAt(0);


        } catch (IOException ioexc) {

        }
    }

}
