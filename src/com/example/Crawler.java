/**
 * Created by robert on 27.03.2017.
 */
package com.example;

import org.apache.commons.io.FileUtils;
import sun.awt.image.ImageWatched;

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Crawler {
    private final List<CrawlerListener> studentAddedListeners = new LinkedList<>();
    private final List<CrawlerListener> studentRemovedListeners = new LinkedList<>();
    private final List<CrawlerListener> studentNoChangeListeners = new LinkedList<>();
    private final List<CrawlerListener> iterationStartedListeners = new LinkedList<>();
    private final List<CrawlerListener> iterationFinishedListeners = new LinkedList<>();
    private final URL url;
    private final String outputDirectory;
    private LinkedList<Student> currentData = new LinkedList<>();
    private long iteration = 0;

    public Crawler(URL url, String outputDirectory) {
        this.url = url;
        this.outputDirectory = outputDirectory;
    }

    public void addStudentAddedListener(CrawlerListener crawlerListener) {
        studentAddedListeners.add(crawlerListener);
    }
    public void addStudentRemovedListener(CrawlerListener crawlerListener) {
        studentRemovedListeners.add(crawlerListener);
    }

    public void addStudentNoChangeListener(CrawlerListener crawlerListener) {
        studentNoChangeListeners.add(crawlerListener);
    }

    public void addIterationStartedListener(CrawlerListener crawlerListener) {
        iterationStartedListeners.add(crawlerListener);
    }

    public void addIterationFinishedListeners(CrawlerListener crawlerListener) {
        iterationFinishedListeners.add(crawlerListener);
    }
    private void listenersCall(CrawlerEventType type, Student student, long iteration) {
        {
            switch (type)
            {

                case ADD:
                    for (CrawlerListener crawlerListener : studentAddedListeners)
                        crawlerListener.actionPerformed(new CrawlerEvent(type, student, iteration));
                    break;

                case DELETE:
                    for (CrawlerListener crawlerListener : studentRemovedListeners)
                        crawlerListener.actionPerformed(new CrawlerEvent(type, student, iteration));
                    break;

                case NO_CHANGE:
                    for (CrawlerListener crawlerListener : studentNoChangeListeners)
                        crawlerListener.actionPerformed(new CrawlerEvent(type, student, iteration));
                    break;

                case ITERATION_START:
                    for (CrawlerListener crawlerListener : iterationStartedListeners)
                        crawlerListener.actionPerformed(new CrawlerEvent(type, null, iteration));
                    break;

                case ITERATION_END:
                    for (CrawlerListener crawlerListener : iterationFinishedListeners)
                        crawlerListener.actionPerformed(new CrawlerEvent(type, null, iteration));
                    break;
            }
        }
    }
    private List<Student> getAdded(List<Student> a,LinkedList<Student> b)
    {
        if(a.size()==0) return b;
        if(b.size()==0) return a;

        for(Student s:a)
        {
            System.out.println(s.toString());
        }
        for(Student s:b)
        {
            System.out.println(s.toString());
        }
        List<Student> result=new LinkedList<Student>();
        result.addAll(b);
        result.removeAll(a);
        return result;
    }
    public void run() throws Exception {
        if (url == null) throw new CrawlerException("Url is null");
        int AmountOfIterations = 2;
        while (AmountOfIterations > 0) {
            listenersCall(CrawlerEventType.ITERATION_START, null, iteration);//wywołanie listenerów
            File tmpFile = new File(outputDirectory + toString().valueOf(iteration));//tworzenie pliku tymczasowego
            FileUtils.copyURLToFile(url, tmpFile);

            LinkedList<Student> previousData = currentData;
            currentData.removeAll(currentData);
            currentData.addAll(StudentsParser.parse(tmpFile));

            currentData.sort((a, b) -> (a.getLastName() + a.getFirstName()).compareToIgnoreCase(b.getLastName() + b.getFirstName()));
            if(previousData!=null&&currentData!=null)
                {
                    List<Student> added = getAdded(previousData,currentData);
                    List<Student> removed = getAdded(currentData,previousData);

                    if(added.size()==0 && removed.size()==0)
                    {
                        for (Student s : currentData)
                        {
                            listenersCall(CrawlerEventType.NO_CHANGE, s, iteration);
                        }
                    }else{
                            for(Student s : added)
                            {
                                listenersCall(CrawlerEventType.ADD,s,iteration);
                            }
                            for(Student s : removed)
                            {
                                listenersCall(CrawlerEventType.DELETE,s,iteration);
                            }
                        }
                    }
                    Thread.sleep(1000);
            iteration++;
            AmountOfIterations--;
            listenersCall(CrawlerEventType.ITERATION_END,null,iteration);
                }
            }
    @SuppressWarnings("Duplicates")
    public List<Student> extractStudents(OrderMode mode) {


        switch (mode) {
            case AGE:
                currentData.sort(Comparator.comparingInt(Student::getAge));
                break;

            case MARK:
                currentData.sort(Comparator.comparingDouble(Student::getMark));
                break;

            case FIRST_NAME:
                currentData.sort(Comparator.comparing(Student::getFirstName));
                break;

            case LAST_NAME:
                currentData.sort(Comparator.comparing(Student::getLastName));
                break;
        }

        return currentData;
    }

    @SuppressWarnings("Duplicates")
    public double extractMark(ExtremumMode mode) {


        currentData.sort(Comparator.comparingDouble(Student::getMark));

        if (mode.equals(ExtremumMode.MAX)) return currentData.get(currentData.size() - 1).getMark();

        return currentData.get(0).getMark();
    }

    @SuppressWarnings("Duplicates")
    public int extractAge(ExtremumMode mode) {


        currentData.sort(Comparator.comparingInt(Student::getAge));

        if (mode.equals(ExtremumMode.MAX)) return currentData.get(currentData.size() - 1).getAge();

        return currentData.get(0).getAge();
    }
}
