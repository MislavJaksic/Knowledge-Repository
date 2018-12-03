#include "unit_testing_catch2.h"

//Source: https://github.com/catchorg/Catch2/tree/master/docs

//TEST_CASE ->test case (_name[, _tags])
//SECTION ->execute outside SECTION code before
//          each inner SECTION code (_name)

//REQUIRE/REQUIRE_FALSE ->assert (_boolean_expression)

//for BDD
//SCENARIO ->
//GIVEN ->
//WHEN ->
//THEN ->

TEST_CASE( "vectors can be sized and resized", "[vector]" )
{

    // For each section, vector v is anew:

    std::vector<int> v( 5 );

    REQUIRE( v.size() == 5 );
    REQUIRE( v.capacity() >= 5 );

    SECTION( "resizing bigger changes size and capacity" )
    {
        v.resize( 10 );

        REQUIRE( v.size() == 10 );
        REQUIRE( v.capacity() >= 10 );
    }
    SECTION( "resizing smaller changes size but not capacity" )
    {
        v.resize( 0 );

        REQUIRE( v.size() == 0 );
        REQUIRE( v.capacity() >= 5 );
    }
    SECTION( "reserving bigger changes capacity but not size" )
    {
        v.reserve( 10 );

        REQUIRE( v.size() == 5 );
        REQUIRE( v.capacity() >= 10 );
    }
    SECTION( "reserving smaller does not change size or capacity" )
    {
        v.reserve( 0 );

        REQUIRE( v.size() == 5 );
        REQUIRE( v.capacity() >= 5 );
    }
}

TEST_CASE( "Fail on purpose" )
{
    REQUIRE( 2 == 1 );
}

TEST_CASE( "Succeed on purpose" )
{
    REQUIRE( 1 == 1 );
}
