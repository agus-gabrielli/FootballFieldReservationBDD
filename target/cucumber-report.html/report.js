$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ReservationTests.feature");
formatter.feature({
  "line": 1,
  "name": "Football field reservation operations",
  "description": "Checking operations regarding reservation of the football field",
  "id": "football-field-reservation-operations",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Successfully reserve when football field is free",
  "description": "",
  "id": "football-field-reservation-operations;successfully-reserve-when-football-field-is-free",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "the field is free from 12 to 14",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "trying to reserve from 12 to 14",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "reservation is made from 12 to 14",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 9,
  "name": "Cannot reserve when football field is not free",
  "description": "",
  "id": "football-field-reservation-operations;cannot-reserve-when-football-field-is-not-free",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "the field is occupied from 12 to 14",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "trying to reserve from 12 to 14",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "reservation is denied due to occupied field",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 14,
  "name": "Cannot reserve when the football field is closed",
  "description": "",
  "id": "football-field-reservation-operations;cannot-reserve-when-the-football-field-is-closed",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "the field is open from 8 to 22",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "trying to reserve from 6 to 7",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "reservation is denied due to closed field",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 19,
  "name": "Cannot reserve for more than 3 hours",
  "description": "",
  "id": "football-field-reservation-operations;cannot-reserve-for-more-than-3-hours",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "the field is free from 12 to 16",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "trying to reserve from 12 to 16",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "reservation is denied due to excess of reservation time",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});