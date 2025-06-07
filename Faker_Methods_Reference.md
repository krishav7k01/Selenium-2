1. Name Generation
faker.name().fullName()
Generates a random full name.
Example: John Doe

faker.name().firstName()
Generates a random first name.
Example: John

faker.name().lastName()
Generates a random last name.
Example: Doe

faker.name().prefix()
Generates a random name prefix (e.g., Mr., Mrs.).
Example: Mr.

faker.name().suffix()
Generates a random name suffix (e.g., Jr., Sr.).
Example: Jr.

faker.name().title()
Generates a random title.
Example: Dr.

------------------------------------------------

2. Internet & Email Generation
faker.internet().emailAddress()
Generates a random email address.
Example: john.doe@example.com

faker.internet().url()
Generates a random URL.
Example: http://example.com

faker.internet().domainName()
Generates a random domain name.
Example: example.com

faker.internet().domainSuffix()
Generates a random domain suffix.
Example: .com

faker.internet().userName()
Generates a random username.
Example: johndoe99

faker.internet().password()
Generates a random password.
Example: abc123xyz

faker.internet().ipV4Address()
Generates a random IPv4 address.
Example: 192.168.1.1

------------------------------------------------

3. Address Generation
faker.address().streetAddress()
Generates a random street address.
Example: 123 Main St

faker.address().city()
Generates a random city name.
Example: Springfield

faker.address().cityName()
Generates a random city name.
Example: Los Angeles

faker.address().streetName()
Generates a random street name.
Example: Maple Street

faker.address().zipCode()
Generates a random ZIP code.
Example: 12345

faker.address().state()
Generates a random state name.
Example: California

faker.address().country()
Generates a random country name.
Example: United States

faker.address().latitude()
Generates a random latitude.
Example: 37.7749

faker.address().longitude()
Generates a random longitude.
Example: -122.4194

------------------------------------------------

4. Phone Number Generation
faker.phoneNumber().phoneNumber()
Generates a random phone number.
Example: (123) 456-7890

faker.phoneNumber().cellPhone()
Generates a random cell phone number.
Example: 555-555-5555

faker.phoneNumber().tollFreePhoneNumber()
Generates a random toll-free phone number.
Example: 800-555-5555

faker.phoneNumber().phoneNumberFormat()
Generates a random phone number with a specific format.
Example: (###) ###-####

------------------------------------------------

5. Company Generation
faker.company().name()
Generates a random company name.
Example: Acme Corporation

faker.company().industry()
Generates a random company industry.
Example: Technology

faker.company().profession()
Generates a random profession.
Example: Software Engineer

faker.company().catchPhrase()
Generates a random company catchphrase.
Example: Innovating the future

faker.company().bs()
Generates random business slogans.
Example: synergize strategic partnerships

------------------------------------------------

6. Text Generation
faker.lorem().word()
Generates a random word.
Example: lorem

faker.lorem().sentence()
Generates a random sentence.
Example: Lorem ipsum dolor sit amet.

faker.lorem().paragraph()
Generates a random paragraph.
Example: Lorem ipsum dolor sit amet, consectetur adipiscing elit.

faker.lorem().text()
Generates a random block of text.
Example: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero.

faker.lorem().characters()
Generates a random string of characters.
Example: xyzt456

------------------------------------------------

7. Date/Time Generation
faker.date().birthday()
Generates a random date of birth.
Example: 1990-05-10

faker.date().past()
Generates a random past date.
Example: 2018-07-14

faker.date().future()
Generates a random future date.
Example: 2023-09-10

faker.date().recent()
Generates a recent date.
Example: 2022-12-31

faker.date().between(startDate, endDate)
Generates a random date between two specific dates.
Example: 2020-01-01 to 2022-12-31

------------------------------------------------

8. Random Numbers
faker.number().randomDigit()
Generates a random single digit.
Example: 4

faker.number().randomNumber()
Generates a random number.
Example: 12345

faker.number().randomDouble()
Generates a random floating-point number.
Example: 12.34

faker.number().numberBetween(1, 100)
Generates a random number within the range.
Example: 57

-----------------------------------------------------

9. Currency & Financial Data
faker.finance().creditCard()
Generates a random credit card number.
Example: 1234 5678 9012 3456

faker.finance().creditCardType()
Generates a random credit card type.
Example: MasterCard

faker.finance().creditCardNumber()
Generates a random credit card number.
Example: 4111111111111111

faker.finance().currencyCode()
Generates a random currency code.
Example: USD

faker.finance().amount()
Generates a random financial amount.
Example: 100.99