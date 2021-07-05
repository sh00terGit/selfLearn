package by.shipul.selflearn.service;

import by.shipul.selflearn.model.Developer;
import by.shipul.selflearn.model.DeveloperStatus;

public interface DeveloperService {

    void notifyAboutDeveloperStatus(Developer developer, DeveloperStatus status);
}
