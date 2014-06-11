package io.lamma

import org.scalatest.{WordSpec, Matchers}

class DateRangeSpec extends WordSpec with Matchers {

  "DateRange" should {
    "work" in {
      val expected = Date(2014, 1, 5) :: Date(2014, 1, 6) :: Date(2014, 1, 7) :: Date(2014, 1, 8) :: Nil
      DateRange(Date(2014, 1, 5), Date(2014, 1, 8)).toList should be(expected)
    }

    "return itself when from date equals to To date" in {
      val expected = Date(2014, 5, 1) :: Nil
      val actual = Date(2014, 5, 1) to Date(2014, 5, 1)
      actual.toList should be(expected)
    }
  }

  "by" should {
    "work for positive step" in {
      val expected = Date(2014, 1, 5) :: Date(2014, 1, 7) :: Nil
      val actual = Date(2014, 1, 5) to Date(2014, 1, 8) by 2
      actual.toList should be(expected)
    }

    "work for negative step" in {
      val expected = Date(2014, 1, 8) :: Date(2014, 1, 6) :: Nil
      val actual = Date(2014, 1, 8) to Date(2014, 1, 5) by -2
      actual.toList should be(expected)
    }

    "return itself when from date equals to To date for positive step" in {
      val expected = Date(2014, 5, 1) :: Nil
      val actual = Date(2014, 5, 1) to Date(2014, 5, 1) by 2
      actual.toList should be(expected)
    }

    "return itself when from date equals to To date for negative step" in {
      val expected = Date(2014, 5, 1) :: Nil
      val actual = Date(2014, 5, 1) to Date(2014, 5, 1) by -2
      actual.toList should be(expected)
    }

    "return empty list when from date is after To date for positive step" in {
      val actual = Date(2014, 5, 5) to Date(2014, 5, 1) by 2
      actual.toList should be(Nil)
    }

    "return empty list when from date is before To date for negative step" in {
      val actual = Date(2014, 5, 1) to Date(2014, 5, 5) by -2
      actual.toList should be(Nil)
    }
  }
}