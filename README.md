Algorithm

POST /rank
{
  "request": [
    {
      "rank": 1,
      "quotation": 2300
    },
    {
      "rank": 2,
      "quotation": 1980
    },
    {
      "rank": 2,
      "quotation": 1500
    },
    {
      "rank": 3,
      "quotation": 1023
    }
  ],
  "response": [
    {
      "delta": 5
    },
    {
      "delta": 2
    },
    {
      "delta": 5
    },
    {
      "delta": -1
    }
  ]
}