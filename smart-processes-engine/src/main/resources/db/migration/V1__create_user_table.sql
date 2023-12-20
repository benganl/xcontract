-- Process Event Table
CREATE TABLE process_event (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);

-- Process State Table
CREATE TABLE process_state (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    start_date DATE,
    end_date DATE,
    create_date DATE
);

-- Process Config Table
CREATE TABLE process_config (
    id UUID PRIMARY KEY,
    current_state_id UUID REFERENCES process_state(id) NOT NULL,
    next_state_id UUID REFERENCES process_state(id) NOT NULL,
    event_id UUID REFERENCES process_event(id) NOT NULL
);

-- Smart Process Table
CREATE TABLE smart_process (
    id UUID PRIMARY KEY,
    external_ref VARCHAR(255),
    current_state UUID REFERENCES process_state(id) NOT NULL
);
