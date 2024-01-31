import pytest
from playwright.sync_api import sync_playwright
import uuid


@pytest.fixture(scope='session')
def dynamic_email():
    # Generate a unique identifier and append it to the base email address
    base_email = "romin.parvardeh+"
    unique_identifier = str(uuid.uuid4().hex)[:8]  # Use the first 8 characters of the UUID
    return f"{base_email}{unique_identifier}@gmail.com"

@pytest.fixture(scope='session')
def dynamic_password():
    # Generate a unique identifier for the dynamic password
    return f"AvivGroupChallange!{uuid.uuid4().hex[:8]}"

@pytest.fixture
def browser():
    with sync_playwright() as p:
        browser = p.chromium.launch(headless=False, slow_mo=50)
        yield browser
        browser.close()


