class Application {
  id: string;
  name: string;
  description: string;
  dateCreated: Date;

  constructor(id: string, name: string, description: string, dateCreated: Date) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.dateCreated = dateCreated;
  }
}

class Event {
  id: string;
  name: string;
  description: string;
  dateCreated: Date;

  constructor(id: string, name: string, description: string, dateCreated: Date) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.dateCreated = dateCreated;
  }
}

class State {
  id: string;
  name: string;
  description: string;
  dateCreated: Date;

  constructor(id: string, name: string, description: string, dateCreated: Date) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.dateCreated = dateCreated;
  }
}

class StateConfig {
  id: string;
  application: Application;
  currentState: State;
  event: Event;
  nextState: State;
  dateCreated: Date;

  constructor(id: string, application: Application, currentState: State, event: Event, nextState: State, dateCreated: Date) {
    this.id = id;
    this.application = application;
    this.currentState = currentState;
    this.event = event;
    this.nextState = nextState;
    this.dateCreated = dateCreated;
  }
}

class StateItem {
  id: string;
  itemRef: string;
  currentState: State;
  dateCreated: Date;

  constructor(id: string, itemRef: string, currentState: State, dateCreated: Date) {
    this.id = id;
    this.itemRef = itemRef;
    this.currentState = currentState;
    this.dateCreated = dateCreated;
  }
}

class StateItemHistory {
  id: string;
  stateItem: StateItem;
  appliedEvent: Event;
  dateCreated: Date;

  constructor(id: string, stateItem: StateItem, appliedEvent: Event, dateCreated: Date) {
    this.id = id;
    this.stateItem = stateItem;
    this.appliedEvent = appliedEvent;
    this.dateCreated = dateCreated;
  }
}

export { Application, Event, State, StateConfig, StateItem, StateItemHistory };
