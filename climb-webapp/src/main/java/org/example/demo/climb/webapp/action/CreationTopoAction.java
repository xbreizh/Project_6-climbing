package org.example.demo.climb.webapp.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.example.demo.climb.business.contract.*;
import org.example.demo.climb.model.bean.Booking;
import org.example.demo.climb.model.bean.Country;
import org.example.demo.climb.model.bean.Spot;
import org.example.demo.climb.model.bean.Topo;
import org.example.demo.climb.model.exception.NotFoundException;

import javax.inject.Inject;
import java.util.*;

public class CreationTopoAction extends LoginAction implements SessionAware {

    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Topo topo;
    private boolean submit;
    private Spot spot;
    private int spotId;
    private int topoId;
    private List<Topo> topoList;
    private List<Integer> yearList = new ArrayList<>();
    private int id;
    private HashMap<Integer, String> countryList = new HashMap<>();
    private Date beginBook;
    private Date endBook;
    private int memberId;
    private List<Booking> conflictList = new ArrayList<>();
    private List<Spot> spotList = new ArrayList<>();
    private List<Booking> bookingList = new ArrayList<>();
    private String yourMonth;
    private Booking booking;


    @Inject
    private TopoManager topoManager;
    @Inject
    private CountryManager countryManager;
    @Inject
    private MemberManager memberManager;
    @Inject
    private SpotManager spotManager;
    @Inject
    private BookingManager bookingManager;

    // CREATE
    public String doCreateTopo() {
        logger.info("trying to create a topo");
        String vResult = ActionSupport.INPUT;
        initCountryList();
        initYearlist();
        if (topo != null) {
            if (checkTopoForm(topo)) {
                logger.info("topo as such: " + topo);
                topoManager.addTopo(topo);
                vResult = ActionSupport.SUCCESS;
            }
        }
        return vResult;
    }

    public void initYearlist() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        logger.info("year found: " + year);
        for (int i = year; i > 1900; i--) {
            yearList.add(i);
        }
        logger.info("yearList size: " + yearList.size());
    }

    public String doEndBooking() {
        String vResult = ActionSupport.SUCCESS;
        logger.info("hello here: " + id);
        bookingManager.endBooking(id);
        return vResult;
    }

    /*READ ONE*/
    public String doDetail() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        topo = topoManager.getTopo(id);
        spotList = createSpotListToBeAdded(topo);

        if (this.hasErrors()) {
            vResult = ActionSupport.ERROR;
        }
        return vResult;
    }

    public List<Spot> createSpotListToBeAdded(Topo topo) {
        spotList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        for (Spot s : topo.getSpots()) {
            intList.add(s.getId());
        }
        for (Spot s : spotManager.getListSpot()) {
            if (!intList.contains(s.getId())) {
                spotList.add(s);
            }
        }

        return spotList;
    }

    /*Add Spot to Topo*/
    public String addSpotToTopo() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        logger.info("topo id: " + id + "  spot id: " + spotId);
        spot = spotManager.getSpotById(spotId);
        topo = topoManager.getTopo(id);
        topoManager.addSpotToTopo(spot, topo);

        return vResult;
    }

    /*Remove Spot from Topo*/
    public String removeSpotFromTopo() throws NotFoundException {
        String vResult = ActionSupport.SUCCESS;
        topoId = topo.getId();
        logger.info("spot id: " + id + "  topo id: " + topoId);
        spot = spotManager.getSpotById(id);
        topo = topoManager.getTopo(topoId);
        logger.info("result: " + topoManager.removeSpotFromTopo(spot, topo));

        return vResult;
    }

    public boolean checkTopoForm(Topo topo) {
        int error = 0;
        // Check Name
        if (topo.getName().length() < 2 || topo.getName().length() > 50) {
            this.addFieldError("topo.name", "name must be between 2-50 characters (" +
                    topo.getName().length() + ")");
            error++;
        }
        // Check Edition
        if (topo.getEdition().length() < 2 || topo.getEdition().length() > 50) {
            this.addFieldError("topo.edition", "edition must be between 2-50  characters (" +
                    topo.getEdition().length() + ")");
            error++;
        }
        // Check Author
        if (topo.getAuthor().length() < 2 || topo.getAuthor().length() > 50) {
            this.addFieldError("topo.author", "author must be between 2-50 characters (" +
                    topo.getAuthor().length() + ")");
            error++;
        }
        // Check Published Year
        if (topo.getPublishedYear() < 1900 || topo.getPublishedYear() > 2221) {
            this.addFieldError("topo.name", "Year must be between 1900-today");
            error++;
        }
        // Check Description
        if (topo.getDescription().length() < 2 || topo.getDescription().length() > 350) {
            this.addFieldError("topo.description", "Description must be between 2-350 characters (" +
                    topo.getDescription().length() + ")");
            error++;
        }
        // Check Keywords
        if (topo.getKeywords().length() < 2 || topo.getKeywords().length() > 50) {
            this.addFieldError("topo.keywords", "Keywords must be between 3-350  characters )" +
                    topo.getKeywords().length() + ")");
            error++;
        }

        // Checks if any error during the checking

        if (error > 0) {
            return false;
        } else {
            return true;
        }

    }

    public String doList() {
        topoList = topoManager.getListTopo();
        logger.info("trying to get topoList");
        logger.info("size: " + topoList.size());
        return ActionSupport.SUCCESS;
    }

    // BOOKING
    public String doBooking() {
        String vResult = ActionSupport.INPUT;

        topo = topoManager.getTopo(id);
        if (booking != null) {
            if (booking.getBookingDate() == null || booking.getPlannedReturnDate() == null) {
                this.addFieldError("booking.plannedReturnDate", "You must fill out both dates to book");
                return vResult;
            } else {
                logger.info("booking beg: " + booking.getBookingDate());
                logger.info("booking end: " + booking.getPlannedReturnDate());
                if (booking.getBookingDate().after(booking.getPlannedReturnDate()) ||
                        booking.getBookingDate().equals(booking.getPlannedReturnDate())) {
                    logger.info("end date must be after begin date");
                    this.addFieldError("booking.plannedReturnDate", "end date must be after begin date");
                    return vResult;
                }
                Date tomo = DateUtils.addDays(new Date(), 1);
                Calendar today = new GregorianCalendar();
                today.set(Calendar.HOUR_OF_DAY, 0);
                today.set(Calendar.MINUTE, 0);
                today.set(Calendar.SECOND, 0);
                today.set(Calendar.MILLISECOND, 0);
                logger.info("tomorrow: " + today + 1);
                logger.info("today: " + today);
                if (booking.getBookingDate().before(today.getTime())) { // converts calendar into date
                    this.addFieldError("booking.bookingDate", "date can't be in the past");
                    logger.info("date can't be in the past");
                    return vResult;
                }
                if (booking.getPlannedReturnDate().compareTo(booking.getBookingDate()) > 7) {
                    this.addFieldError("booking.plannedReturnDate", "You can book for maximum 7 days!");
                    logger.info("start date should be at least tomorrow");
                    return vResult;
                }

                conflictList = bookingManager.addBooking(booking);
                if (conflictList.size() == 0) {
                    return ActionSupport.SUCCESS;
                } else {
                    logger.info(conflictList.size());
                    for (Booking b : conflictList
                    ) {
                        logger.info("conflict id: " + b.getId());
                    }
                    this.addFieldError("booking.plannedReturnDate", "there are some booking conflicts");
                }
            }


        }
        return vResult;
    }

    public String doValidateBooking() {

        return ActionSupport.SUCCESS;
    }

    private void initCountryList() {
        for (Country c : countryManager.getListCountry()
        ) {
            countryList.put(c.getId(), c.getName());
        }
    }

    public String doListBooking() throws Exception {

        bookingList = bookingManager.getListBooking();
        return "success";
    }

    public String doEditTopo() throws Exception {
        return "success";
    }

    public String doUpdateTopo() throws Exception {
        String vResult = ActionSupport.INPUT;

        initCountryList();
        initYearlist();
        if (topo != null && submit) {
            id = topo.getId();
            if (checkTopoForm(topo)) {
                logger.info("check topo happy");
                topoManager.updateTopo(topo);
                vResult = ActionSupport.SUCCESS;
            } else {
                logger.info("check topo not happy");
            }
        } else {
            logger.info("getting topo");
            topo = topoManager.getTopo(id);
        }
        return vResult;
    }

    // DELETE
    public String doDeleteTopo() throws Exception {
        String vResult = ActionSupport.SUCCESS;
        topo = topoManager.getTopo(id);
        logger.info("trying to delete topo from action: " + topo);
        logger.info("name: " + topo.getName());
        topoManager.deleteTopo(topo);
        return vResult;
    }

    /***********************************************************************/
    /************************ GETTERS - SETTERS ***************************/
    /***********************************************************************/

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public List<Topo> getTopoList() {
        return topoList;
    }

    public void setTopoList(List<Topo> topoList) {
        this.topoList = topoList;
    }

    public List<Integer> getYearList() {
        return yearList;
    }

    public void setYearList(List<Integer> yearList) {
        this.yearList = yearList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, String> getCountryList() {
        return countryList;
    }

    public void setCountryList(HashMap<Integer, String> countryList) {
        this.countryList = countryList;
    }

    public Date getEndBook() {
        return endBook;
    }

    public void setEndBook(Date endBook) {
        this.endBook = endBook;
    }

    public Date getBeginBook() {
        return beginBook;
    }

    public void setBeginBook(Date beginBook) {
        this.beginBook = beginBook;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public List<Booking> getConflictList() {
        return conflictList;
    }

    public void setConflictList(List<Booking> conflictList) {
        this.conflictList = conflictList;
    }

    public List<Spot> getSpotList() {
        return spotList;
    }

    public void setSpotList(List<Spot> spotList) {
        this.spotList = spotList;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int topoId) {
        this.topoId = topoId;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public boolean isSubmit() {
        return submit;
    }

    public void setSubmit(boolean submit) {
        this.submit = submit;
    }

    public String getYourMonth() {
        return yourMonth;
    }

    public void setYourMonth(String yourMonth) {
        this.yourMonth = yourMonth;
    }
}
