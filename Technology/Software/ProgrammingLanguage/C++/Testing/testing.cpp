#include "testing.h"

int main(void)
{
    Timer timer;

    std::cout << "Time elapsed: " << timer.elapsed() << " seconds\n";

    assert(1 < 2 && "This will pass"); //trick assert to print a message
    assert(1 > 2 && "This will fail");
    return 0;
}
